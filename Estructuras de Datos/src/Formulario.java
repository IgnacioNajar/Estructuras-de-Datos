import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario frame = new Formulario();
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
    public Formulario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 203);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(42, 40, 322, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Verificar fórmula");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (estaBalanceada()) {
                    setTitle("Está correctamente balanceada.");
                } else {
                    setTitle("No está correctamente balanceada.");
                }
            }
        });
        btnNewButton.setBounds(41, 93, 152, 23);
        contentPane.add(btnNewButton);
    }

    public boolean estaBalanceada() {
        Pila2 pila1 = new Pila2();
        String cadena = textField.getText();

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pila1.insertar(c);
            } else {
                if (c == ')') {
                    if (pila1.extraer() != '(') {
                        return false;
                    }
                } else if (c == ']') {
                    if (pila1.extraer() != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    if (pila1.extraer() != '{') {
                        return false;
                    }
                }
            }
        }

        return pila1.estaVacia();
    }
}
