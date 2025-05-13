import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario3 extends JFrame {

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
                    Formulario3 frame = new Formulario3();
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
    public Formulario3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 463);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        l1 = new JLabel("Clientes atendidos por caja:");
        l1.setBounds(101, 33, 400, 14);
        contentPane.add(l1);

        l2 = new JLabel("Se marchan sin hacer compras:");
        l2.setBounds(101, 70, 300, 14);
        contentPane.add(l2);

        l3 = new JLabel("Tiempo promedio en cola:");
        l3.setBounds(101, 111, 300, 14);
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
        //Variables de estado
        int estado1 = 0, estado2 = 0, estado3 = 0;
        //Variables de llegada y salida
        int llegada = 2 + (int) (Math.random() * 2);
        int salida1 = -1, salida2 = -1, salida3 = -1;
        //Variables de contadores
        int cantidadPersonasAtendidas1 = 0, cantidadPersonasAtendidas2 = 0, cantidadPersonasAtendidas3 = 0;
        int personasMarchadas = 0;
        int tiempoEnCola = 0;
        int cantidadEnCola = 0;

        Cola3 cola1, cola2, cola3;
        cola1 = new Cola3();
        cola2 = new Cola3();
        cola3 = new Cola3();

        for (int minuto = 0; minuto < 480; minuto++) {
            if (llegada == minuto) {
                if (estado1 == 0) {
                    estado1 = 1;
                    salida1 = minuto + 7 + (int) (Math.random() * 5);
                } else if (estado2 == 0) {
                    estado2 = 1;
                    salida2 = minuto + 7 + (int) (Math.random() * 5);
                } else if (estado3 == 0) {
                    estado3 = 1;
                    salida3 = minuto + 7 + (int) (Math.random() * 5);
                } else {
                    int c1 = cola1.cantidad();
                    int c2 = cola2.cantidad();
                    int c3 = cola3.cantidad();

                    if (c1 < 6 && c1 <= c2 && c1 <= c3) {
                        cola1.insertar(minuto);
                    } else if (c2 < 6 && c2 <= c1 && c2 <= c3) {
                        cola2.insertar(minuto);
                    } else if (c3 < 6 && c3 <= c1 && c3 <= c2) {
                        cola3.insertar(minuto);
                    } else {
                        personasMarchadas++;
                    }
                }
                llegada = minuto + 2 + (int) (Math.random() * 2);
            }

            if (estado1 == 1 && minuto == salida1) {
                cantidadPersonasAtendidas1++;
                if (!cola1.estaVacia()) {
                    int llegadaCliente = cola1.extraer();
                    tiempoEnCola += minuto - llegadaCliente;
                    cantidadEnCola++;
                    salida1 = minuto + 7 + (int)(Math.random() * 5);
                } else {
                    estado1 = 0;
                }
            }

            if (estado2 == 1 && minuto == salida2) {
                cantidadPersonasAtendidas2++;
                if (!cola2.estaVacia()) {
                    int llegadaCliente = cola2.extraer();
                    tiempoEnCola += minuto - llegadaCliente;
                    cantidadEnCola++;
                    salida2 = minuto + 7 + (int)(Math.random() * 5);
                } else {
                    estado2 = 0;
                }
            }

            if (estado3 == 1 && minuto == salida3) {
                cantidadPersonasAtendidas3++;
                if (!cola3.estaVacia()) {
                    int llegadaCliente = cola3.extraer();
                    tiempoEnCola += minuto - llegadaCliente;
                    cantidadEnCola++;
                    salida3 = minuto + 7 + (int)(Math.random() * 5);
                } else {
                    estado3 = 0;
                }
            }
        }

        l1.setText("Clientes atendidos por caja: Caja 1: " + cantidadPersonasAtendidas1 + " - Caja 2: " + cantidadPersonasAtendidas2 +" - Caja 3: " + cantidadPersonasAtendidas3);
        l2.setText("Se marchan sin hacer compras: " + personasMarchadas + " clientes");
        if (cantidadEnCola > 0) {
            int tiempoPromedio = tiempoEnCola / cantidadEnCola;
            l3.setText("Tiempo promedio en cola: " + tiempoPromedio + " minutos");
        }
    }
}
