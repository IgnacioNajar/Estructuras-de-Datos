public class Recursividad2 {
    void imprimirDescendente(int n) {
        if (n < 0) return;
        System.out.println(n);
        imprimirDescendente(n - 1);
    }

    void imprimirAscendente(int n) {
        if (n < 0) return;
        imprimirAscendente(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Recursividad2 recursividad = new Recursividad2();
        System.out.println("Impresión descendente:");
        recursividad.imprimirDescendente(10);

        System.out.println("");
        
        System.out.println("Impresión ascendente:");
        recursividad.imprimirAscendente(10);
    }
}
