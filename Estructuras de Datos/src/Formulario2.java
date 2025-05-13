import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario2 extends JFrame {

    private JPanel contentPane;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario2 frame = new Formulario2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Formulario2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 463);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        l1 = new JLabel("Atendidos:");
        l1.setBounds(101, 33, 218, 14);
        contentPane.add(l1);

        l2 = new JLabel("En cola:");
        l2.setBounds(101, 70, 189, 14);
        contentPane.add(l2);

        l3 = new JLabel("Minuto de llegada:");
        l3.setBounds(101, 111, 189, 14);
        contentPane.add(l3);

        JButton btnNewButton = new JButton("Procesar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                simulacion();
            }
        });
        btnNewButton.setBounds(96, 153, 89, 23);
        contentPane.add(btnNewButton);
    }

    private void simulacion() {
        int estado = 0;
        int llegada = 2 + (int) (Math.random() * 2);
        int salida = -1;
        int cantidadPersonasAtendidas = 0;
        Cola3 cola = new Cola3();

        for (int minuto = 0; minuto < 600; minuto++) {
            if (llegada == minuto) {
                if (estado == 0) {
                    estado = 1;
                    salida = minuto + 2 + (int) (Math.random() * 3);
                } else {
                    cola.insertar(minuto);
                }
                llegada = minuto + 2 + (int) (Math.random() * 2);
            }

            if (salida == minuto) {
                estado = 0;
                cantidadPersonasAtendidas++;
                if (!cola.estaVacia()) {
                    cola.extraer();
                    estado = 1;
                    salida = minuto + 2 + (int) (Math.random() * 3);
                }
            }
        }

        l1.setText("Atendidos: " + cantidadPersonasAtendidas);
        l2.setText("En cola: " + cola.cantidad());

        if (!cola.estaVacia()) {
            l3.setText("Minuto llegada: " + cola.extraer());
        } else {
            l3.setText("Minuto llegada: -");
        }
    }
}
