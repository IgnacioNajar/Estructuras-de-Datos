class Recursividad6 {
    static int[] arr = {312, 614, 88, 22, 54};

    void ordenar(int[] arr, int cantidad) {
        if (cantidad > 1) {
            for (int i = 0; i < cantidad - 1; i++) {

                if (arr[i] > arr[i + 1]) {
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                }

            }
            ordenar(arr, cantidad - 1);
        }
    }

    void imprimir() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");
    }

    public static void main(String[] ar) {
        Recursividad6 recursividad = new Recursividad6();
        System.out.println("Arreglo antes de ordenar:");
        recursividad.imprimir();

        recursividad.ordenar(arr, arr.length);

        System.out.println("Arreglo después de ordenar:");
        recursividad.imprimir();
    }
}