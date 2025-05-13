public class Cola3 {
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz, fin;

    Cola3() {
        raiz = null;
        fin = null;
    }

    public boolean estaVacia() {
        return raiz == null;
    }

    public void insertar(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.info = valor;
        nuevo.siguiente = null;

        if (estaVacia()) {
            raiz = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public int extraer() {
        if (!estaVacia()) {
            int informacion = raiz.info;

            if (raiz == fin) {
                raiz = null;
                fin = null;
            } else {
                raiz = raiz.siguiente;
            }
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void imprimir() {
        Nodo recorrer = raiz;
        System.out.println("Listado de todos los elementos de la cola:");
        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("\n");
    }

    public int cantidad() {
        Nodo recorrer = raiz;
        int cantidad = 0;

        while (recorrer != null) {
            cantidad++;
            recorrer = recorrer.siguiente;
        }
        return cantidad;
    }
}
