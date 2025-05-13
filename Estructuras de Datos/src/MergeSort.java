public class MergeSort {

    // Método principal de ordenamiento (divide y conquista)
    public void mergeSort(int[] arr) {
        // Solo se ordena si el arreglo tiene más de un elemento
        if (arr.length > 1) {
            // Calcular punto medio del arreglo
            int mid = arr.length / 2;

            // Crear subarreglos izquierdo y derecho
            int[] L = new int[mid];
            int[] R = new int[arr.length - mid];

            // Copiar elementos a L
            for (int i = 0; i < mid; i++) {
                L[i] = arr[i];
            }

            // Copiar elementos a R
            for (int i = mid; i < arr.length; i++) {
                R[i - mid] = arr[i];
            }

            // Llamadas recursivas para ordenar las mitades
            mergeSort(L);
            mergeSort(R);

            // Mezclar las mitades ordenadas en el arreglo original
            merge(arr, L, R);
        }
    }

    // Método para mezclar dos subarreglos ordenados en uno solo
    public void merge(int[] arr, int[] L, int[] R) {
        int i = 0; // índice para recorrer L
        int j = 0; // índice para recorrer R
        int k = 0; // índice para el arreglo final arr

        // Comparar elementos de L y R, y colocarlos ordenadamente en arr
        while (i < L.length && j < R.length) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes de L (si quedan)
        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar elementos restantes de R (si quedan)
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Método para imprimir un arreglo
    public void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método main para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {312, 614, 88, 22, 54};

        MergeSort ms = new MergeSort();

        System.out.println("Antes de ordenar:");
        ms.imprimirArray(arreglo);

        ms.mergeSort(arreglo); // Llamar al método de ordenamiento

        System.out.println("Después de ordenar:");
        ms.imprimirArray(arreglo);
    }
}