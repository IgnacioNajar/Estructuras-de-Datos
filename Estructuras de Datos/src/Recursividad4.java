public class Recursividad4 {
    void imprimir(int n) {
        System.out.println("Llamada a imprimir(" + n + ")");
        if (n > 0) {
            imprimir(n - 1);
            System.out.println("Imprimiendo: " + n);
        }
        
        System.out.println("Retornando de imprimir(" + n + ")");
    }

    public static void main(String[] args) {
        Recursividad4 recursividad = new Recursividad4();
        recursividad.imprimir(10);
    }
}
