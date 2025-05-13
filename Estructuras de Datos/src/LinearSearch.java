public class LinearSearch {   
    // Método de búsqueda lineal para encontrar la posición de un elemento
    public int busquedaLineal(int[] arreglo, int clave) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == clave) {
                return i; // Devolvemos la posición del elemento encontrado
            }
        }
        return -1; // Si el elemento no se encuentra, devolvemos -1
    }

    // Método principal para probar la búsqueda lineal
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        LinearSearch busqueda = new LinearSearch();
        int indice = busqueda.busquedaLineal(arreglo, 5);
        
        // Verificar si el elemento fue encontrado o no
        if (indice == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en la posición: " + indice);
        }
    }
}