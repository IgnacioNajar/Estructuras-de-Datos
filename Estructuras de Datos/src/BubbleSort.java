public class BubbleSort {

    // Método que implementa el algoritmo de ordenamiento burbuja
    public void ordenarBurbuja(int[] arr) {
        int longitud = arr.length;

        // Recorremos el array tantas veces como elementos tenga menos uno
        for (int pasada = 0; pasada < longitud - 1; pasada++) {
            boolean huboIntercambio = false;

            // Recorremos los elementos no ordenados del array
            for (int i = 0; i < longitud - pasada - 1; i++) {
                // Si el elemento actual es mayor que el siguiente, los intercambiamos
                if (arr[i] > arr[i + 1]) {
                    int temporal = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temporal;
                    huboIntercambio = true;
                }
            }

            // Si no hubo ningún intercambio, el array ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }
    }

    // Método para imprimir el contenido del array
    public void imprimirarr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        BubbleSort ordenamiento = new BubbleSort();

        System.out.println("arr antes de ordenar:");
        ordenamiento.imprimirarr(arr);

        ordenamiento.ordenarBurbuja(arr);

        System.out.println("arr después de ordenar:");
        ordenamiento.imprimirarr(arr);
    }
}