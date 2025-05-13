public class InsertionSort {
    // Método de ordenamiento por inserción
    public void ordenamientoPorInsercion(int[] arreglo) {
        // Comienza desde el segundo elemento y lo compara con los anteriores
        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i];  // Elemento que se va a insertar
            int j = i - 1;

            // Mueve los elementos mayores que clave hacia la derecha
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            
            // Inserta el elemento en su posición correcta
            arreglo[j + 1] = clave;
        }
    }

    // Método principal para probar el ordenamiento por inserción
    public static void main(String[] args) {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};  // Arreglo de ejemplo

        InsertionSort is = new InsertionSort();  // Crear instancia de InsertionSort
        is.ordenamientoPorInsercion(arreglo);  // Ordenar el arreglo
        System.out.println("Arreglo ordenado: " + java.util.Arrays.toString(arreglo));  // Imprimir el arreglo ordenado
    }
}