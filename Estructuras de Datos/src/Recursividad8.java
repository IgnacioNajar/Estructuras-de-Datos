import java.io.File;

public class Recursividad8 {

    // Método recursivo para leer directorios
    public void leer(String inicio, String altura) {
        // Crear un objeto File que representa el directorio de inicio
        File ar = new File(inicio);
        
        // Obtener la lista de archivos y directorios dentro de 'inicio'
        String[] dir = ar.list();

        // Verificar si se pudo acceder al directorio
        if (dir == null) {
            // Si no se puede acceder, imprimir un mensaje y terminar el método
            System.out.println("No se puede acceder al directorio: " + inicio);
            return; // Termina la ejecución de la función recursiva
        }

        // Recorrer cada elemento dentro del directorio
        for (int i = 0; i < dir.length; i++) {
            // Crear un objeto File para cada archivo o subdirectorio
            File ar2 = new File(inicio + "\\" + dir[i]);

            // Verificar si es un directorio (carpeta)
            if (ar2.isDirectory()) {
                // Imprimir el nombre del directorio con una indentación
                System.out.println(altura + "Directorio: " + dir[i].toUpperCase());
                
                // Llamar recursivamente a 'leer' para explorar este subdirectorio
                // Se añade un espacio a la variable 'altura' para mostrar la jerarquía
                leer(inicio + "\\" + dir[i], altura + " ");
            }
        }
    }

    // Método principal donde se inicia el proceso
    public static void main(String[] arguments) {
        // Crear una instancia de la clase Recursividad8
        Recursividad8 rec = new Recursividad8();
        
        // Llamar al método 'leer' con el directorio de inicio y una cadena vacía para la altura
        rec.leer("C:\\Users\\nacho\\Documents", "");
    }
}
