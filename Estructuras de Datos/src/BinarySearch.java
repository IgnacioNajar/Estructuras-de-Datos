public class BinarySearch {

    // Método que realiza la búsqueda binaria en un arreglo ordenado
    public int busqeudaBinaria(int[] arreglo, int clave) {
        int inferior = 0;
        int superior = arreglo.length - 1;

        // Mientras el índice inferior no sobrepase al superior
        while (inferior <= superior) {
            int medio = inferior + (superior - inferior) / 2;

            // Si encontramos la clave, devolvemos su posición
            if (arreglo[medio] == clave) {
                return medio;
            } 
            // Si el valor medio es menor que la clave, buscar en la mitad derecha
            else if (arreglo[medio] < clave) {
                inferior = medio + 1;
            } 
            // Si el valor medio es mayor que la clave, buscar en la mitad izquierda
            else {
                superior = medio - 1;
            }
        }

        // Si no se encuentra la clave, devolver -1
        return -1;
    }

    // Método principal para probar la búsqueda binaria
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BinarySearch buscador = new BinarySearch();
        int posicion = buscador.busqeudaBinaria(arreglo, 5);

        if (posicion == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en la posición: " + posicion);
        }
    }
}