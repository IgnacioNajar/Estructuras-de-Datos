public class Recursividad7 {
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;

    Recursividad7() {
        raiz = null;
    }

    public void insertarPrimero(int valor) {
        Nodo nodoNuevo = new Nodo ();
        nodoNuevo.info = valor;

        nodoNuevo.siguiente = raiz;
        raiz = nodoNuevo;
    }

    public void imprimirInversa(Nodo recorrer) {
        if (recorrer != null) {
            imprimirInversa(recorrer.siguiente);
            System.out.print(recorrer.info + " <- ");
        }
    }
    public void imprimirInversa () {
        imprimirInversa(raiz);
    }
    public static void main(String[] args) {
        Recursividad7 recursividad = new Recursividad7();
        recursividad.insertarPrimero(1);
        recursividad.insertarPrimero(2);
        recursividad.insertarPrimero(3);
        recursividad.insertarPrimero(4);
        recursividad.insertarPrimero(5);
        recursividad.imprimirInversa();
    }
}