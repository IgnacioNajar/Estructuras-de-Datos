public class Pila2 {
    class Nodo {
        char simbolo;
        Nodo siguiente;
    }

    private Nodo raiz;

    Pila2 () {
        raiz = null;
    }

    public void insertar(char valor) {
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.simbolo = valor;

        if (estaVacia()) {
            nodoNuevo.siguiente = null;
            raiz = nodoNuevo;
        }
        else {
            nodoNuevo.siguiente = raiz;
            raiz = nodoNuevo;
        }
    }

    public char extraer () {
        if (!estaVacia()) {
            char informacion = raiz.simbolo;
            raiz = raiz.siguiente;
            return informacion;
        } else {
            return Character.MAX_VALUE;
        }
    }

    public boolean estaVacia() {
        return raiz == null;
    }
}