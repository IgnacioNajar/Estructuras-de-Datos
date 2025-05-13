public class Recursividad5 {
    int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Recursividad5 recursividad = new Recursividad5();
        System.out.println("El factorial de 5 es: " + recursividad.factorial(5) + "\n");
    }
}
