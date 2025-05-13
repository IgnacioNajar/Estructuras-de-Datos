import java.util.LinkedList;
import java.util.Queue;

public class SimulacionCola {

    public static void main(String[] args) {
        simulacion();
    }

    public static void simulacion() {
        int estado = 0; // 0 = libre, 1 = ocupado
        int llegada = 2 + (int) (Math.random() * 2);
        int salida = -1;
        int cantidadPersonasAtendidas = 0;
        Queue<Integer> cola = new LinkedList<>();

        System.out.println("Inicio de simulación de atención (10 horas = 600 minutos):\n");

        for (int minuto = 0; minuto < 600; minuto++) {

            // Llegada de una persona
            if (minuto == llegada) {
                System.out.println("Minuto " + minuto + ": Llega una persona.");

                if (estado == 0) {
                    estado = 1;
                    salida = minuto + 2 + (int) (Math.random() * 3);
                    System.out.println("Minuto " + minuto + ": Persona atendida directamente. Saldrá en " + salida);
                } else {
                    cola.add(minuto);
                    System.out.println("Minuto " + minuto + ": Persona entra en la cola. Tamaño cola: " + cola.size());
                }

                // Próxima llegada
                llegada = minuto + 2 + (int) (Math.random() * 2);
            }

            // Salida de una persona
            if (minuto == salida) {
                estado = 0;
                cantidadPersonasAtendidas++;
                System.out.println("Minuto " + minuto + ": Atención finalizada. Personas atendidas: " + cantidadPersonasAtendidas);

                if (!cola.isEmpty()) {
                    int llegadaPersona = cola.poll();
                    estado = 1;
                    salida = minuto + 2 + (int) (Math.random() * 3);
                    System.out.println("Minuto " + minuto + ": Se comienza a atender a persona de la cola (llegó en minuto " + llegadaPersona + "). Saldrá en " + salida);
                }
            }
        }

        // Resultados finales
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Personas atendidas: " + cantidadPersonasAtendidas);
        System.out.println("Personas en cola al final: " + cola.size());

        if (!cola.isEmpty()) {
            System.out.println("Primera persona en cola llegó en el minuto: " + cola.peek());
        } else {
            System.out.println("No quedó nadie en la cola.");
        }
    }
}
