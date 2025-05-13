class Recursividad6 {
    static int[] array = {312, 614, 88, 22, 54};

    void ordenar(int[] array, int cantidad) {
        if (cantidad > 1) {
            // Realizar una pasada de burbuja para ordenar los elementos
            for (int f = 0; f < cantidad - 1; f++) {
                if (array[f] > array[f + 1]) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    int aux = array[f];
                    array[f] = array[f + 1];
                    array[f + 1] = aux;
                }
            }
            // Llamada recursiva con una cantidad menor de elementos
            ordenar(array, cantidad - 1);
        }
    }

    void imprimir() {
        // Imprimir los elementos del arreglo
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] ar) {
        Recursividad6 recursividad = new Recursividad6();
        System.out.println("Arreglo antes de ordenar:");
        recursividad.imprimir();  // Imprime el arreglo original

        recursividad.ordenar(array, array.length);  // Llama a la función de ordenamiento recursiva

        System.out.println("Arreglo después de ordenar:");
        recursividad.imprimir();  // Imprime el arreglo después de ordenarlo
    }
}
