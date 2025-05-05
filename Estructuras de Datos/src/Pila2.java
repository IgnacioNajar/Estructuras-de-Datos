public class Pila2 {
    class Nodo {
        char simbolo;
        Nodo sig;
    }
    private Nodo raiz;

    Pila2 () {
        raiz=null;
    }

    public void insertar(char valor) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.simbolo = valor;

        if (raiz==null) {
            nuevo.sig = null;
            raiz = nuevo;
        }
        else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }

    public char extraer () {
        if (raiz!=null)
        {
            char informacion = raiz.simbolo;
            raiz = raiz.sig;
            return informacion;
        } else {
            return Character.MAX_VALUE;
        }
    }

    public boolean estaVacia() {
        if (raiz==null) {
            return true;
        } else {
            return false;
        }
    }
}