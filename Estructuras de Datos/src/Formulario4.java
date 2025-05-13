import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario4 extends JFrame {
    private JPanel contentPane;
    private JLabel[][] l;
    private boolean salida;

    // Método para lanzar la aplicación
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario4 frame = new Formulario4();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor para inicializar el JFrame y los componentes
    public Formulario4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 604, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Botón para recorrer el laberinto
        JButton btnRecorrer = new JButton("Recorrer");
        btnRecorrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                salida = false;
                recorrer(0, 0); // Comienza en la posición inicial
                if (salida)
                    setTitle("Tiene salida");
                else
                    setTitle("No tiene salida");
            }
        });
        btnRecorrer.setBounds(10, 11, 89, 23);
        contentPane.add(btnRecorrer);

        // Botón para crear un nuevo laberinto
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crear(); // Genera un nuevo laberinto aleatorio
            }
        });
        btnCrear.setBounds(109, 11, 89, 23);
        contentPane.add(btnCrear);

        // Inicialización del array de etiquetas (JLabel)
        l = new JLabel[10][10];
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                l[f][c] = new JLabel();
                l[f][c].setBounds(20 + c * 20, 50 + f * 20, 20, 20);
                add(l[f][c]);
            }
        }
        crear(); // Llama al método crear al iniciar
    }

    // Método para crear el laberinto con valores aleatorios
    public void crear() {
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                int a = (int) (Math.random() * 4); // Genera números aleatorios entre 0 y 3
                l[f][c].setForeground(Color.black);
                if (a == 0)
                    l[f][c].setText("1"); // Representa una pared
                else
                    l[f][c].setText("0"); // Representa un pasillo
            }
        }
        l[9][9].setText("S"); // La salida se coloca en la fila 9, columna 9
        l[0][0].setText("0"); // La persona comienza en la fila 0, columna 0
    }

    // Método recursivo para recorrer el laberinto
    public void recorrer(int fil, int col) {
        if (fil >= 0 && fil < 10 && col >= 0 && col < 10 && !salida) {
            if (l[fil][col].getText().equals("S")) // Si se encuentra la salida
                salida = true;
            else if (l[fil][col].getText().equals("0")) { // Si es un pasillo
                l[fil][col].setText("9"); // Marca la posición de la persona
                l[fil][col].setForeground(Color.red); // Cambia el color para mostrar la persona

                // Llamadas recursivas a las 4 direcciones (derecha, abajo, arriba, izquierda)
                recorrer(fil, col + 1); // Moverse hacia la derecha
                recorrer(fil + 1, col); // Moverse hacia abajo
                recorrer(fil - 1, col); // Moverse hacia arriba
                recorrer(fil, col - 1); // Moverse hacia la izquierda
            }
        }
    }
}
