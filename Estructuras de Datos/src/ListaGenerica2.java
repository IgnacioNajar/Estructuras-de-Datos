public class ListaGenerica2 {
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;
    private int tamaño;

    ListaGenerica2() {
        raiz = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return raiz == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Nodo creacionDeNodo(int valor) {
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;

        return nodoNuevo;
    }

    public void insertarAlPrincipio(int valor) {
        Nodo nodoNuevo = creacionDeNodo(valor);

        nodoNuevo.siguiente = raiz;
        raiz = nodoNuevo;
        tamaño++;
    }

    public void insertarAlFinal(int valor) {
        if (estaVacia()) {
            insertarAlPrincipio(valor);
        } else {
            Nodo nodoNuevo = creacionDeNodo(valor);
            Nodo recorrer = raiz;

            while (recorrer.siguiente != null) {
                recorrer = recorrer.siguiente;
            }

            recorrer.siguiente = nodoNuevo;
            tamaño++;
        }
    }

    public void insertarSegundaPosicion(int valor) {
        if (estaVacia()) {
            System.out.println("La lista se encuentra vacía, no se puede insertar en la segunda posición.");
            return;
        }

        Nodo nodoNuevo = creacionDeNodo(valor);
        
        if (tamaño == 1) {
            raiz.siguiente = nodoNuevo;
        } else {
            nodoNuevo.siguiente = raiz.siguiente;
            raiz.siguiente = nodoNuevo;
        }
        tamaño++;
    }

    public void insertarPenultimaPosicion(int valor) {
        if (tamaño < 2) {
            System.out.println("La lista debe tener al menos dos nodos para insertar en la penúltima posición.");
            return;
        }

        Nodo nodoNuevo = creacionDeNodo(valor);
        Nodo recorrer = raiz;

        while (recorrer.siguiente.siguiente != null) {
            recorrer = recorrer.siguiente;
        }

        nodoNuevo.siguiente = recorrer.siguiente;
        recorrer.siguiente = nodoNuevo;
        tamaño++;
    }

    public void borrarPrimerNodo() {
        if (estaVacia()) {
            System.out.println("La lista se encuentra vacía, no se puede borrar.");
            return;
        }

        if (tamaño == 1) {
            raiz = null;
        } else {
            raiz = raiz.siguiente;
        }

        tamaño--;
    }

    public void borrarSegundoNodo() {
        if (tamaño < 2) {
            System.out.println("La lista debe tener al menos dos nodos para borrar la segunda posición.");
            return;
        }

        if (tamaño == 2) {
            raiz.siguiente = null;
        } else {
            raiz.siguiente = raiz.siguiente.siguiente;
        }

        tamaño--;
    }

    public void borrarUltimoNodo() {
        if (estaVacia()) {
            System.out.println("La lista se encuentra vacía, no se puede borrar el ultimo nodo.");
            return;
        }

        if (tamaño == 1) {
            raiz = null;
        } else {
            Nodo recorrer = raiz;

            while (recorrer.siguiente.siguiente != null) {
                recorrer = recorrer.siguiente;
            }

            recorrer.siguiente = null;
        }
        
        tamaño--;
    }

    public void borrarNodoMayorInformacion() {
        Nodo actual = raiz.siguiente;
        int mayor = raiz.info;
        
        while (actual != null) {
            if (actual.info > mayor) {
                mayor = actual.info;
            }

            actual = actual.siguiente;
        }

        if (raiz.info == mayor) {
            borrarPrimerNodo();
            return;
        }

        Nodo nodoAnterior = raiz;
        Nodo nodoSiguiente = nodoAnterior.siguiente;

        while (nodoSiguiente != null) {
            if (nodoSiguiente.info == mayor) {
                nodoAnterior.siguiente = nodoSiguiente.siguiente;
                tamaño--;
                return;
            }
            
            nodoAnterior = nodoSiguiente;
            nodoSiguiente = nodoSiguiente.siguiente;
        }
    }

    public void imprimir() {
        Nodo recorrer = raiz;
        System.out.println("Listado de todos los elementos de la lista:");
        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        ListaGenerica2 lista = new ListaGenerica2();

        lista.insertarAlPrincipio(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(25);
        lista.insertarAlFinal(15);
        lista.insertarAlPrincipio(50);
        lista.imprimir();

        lista.insertarSegundaPosicion(99);
        lista.imprimir();

        lista.insertarPenultimaPosicion(88);
        lista.imprimir();

        lista.borrarPrimerNodo();
        lista.imprimir();

        lista.borrarSegundoNodo();
        lista.imprimir();

        lista.borrarUltimoNodo();
        lista.imprimir();

        lista.borrarNodoMayorInformacion();
        lista.imprimir();
    }
}