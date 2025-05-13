public class QuickSort {

    // Método público que inicia el algoritmo
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Método privado recursivo que realiza el ordenamiento
    private void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(arr, inicio, fin);

            // Ordenar la parte izquierda y derecha del pivote
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    // Método para realizar la partición del arreglo
    private int particionar(int[] arr, int inicio, int fin) {
        int pivote = arr[fin]; // Se elige el último elemento como pivote
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                // Intercambiar arr[i] con arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Colocar el pivote en su posición correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1; // Retornar el índice del pivote
    }

    // Método para imprimir el arreglo
    public void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método main para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {312, 614, 88, 22, 54};

        QuickSort qs = new QuickSort();

        System.out.println("Antes de ordenar:");
        qs.imprimirArray(arreglo);

        qs.quickSort(arreglo);

        System.out.println("\nDespués de ordenar:");
        qs.imprimirArray(arreglo);
    }
}