public class Recursividad3 {
    void imprimir(int n) {
        System.out.println("Llamada a imprimir(" + n + ")");
        
        if (n > 0) {
            System.out.println("Imprimiendo: " + n);
            imprimir(n - 1);
        }
        
        System.out.println("Retornando de imprimir(" + n + ")");
    }

    public static void main(String[] args) {
        Recursividad3 recursividad = new Recursividad3();
        recursividad.imprimir(10);
    }
}
