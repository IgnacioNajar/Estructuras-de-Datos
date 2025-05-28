public class ArbolBinario2 {

    // Clase interna para representar los nodos del árbol
    class Nodo {
        int info;
        Nodo izquierdo, derecho;
    }

    private Nodo raiz;
    private int cantidad;     // Auxiliar para contar nodos
    private int altura;   // Auxiliar para calcular altura

    // Inserta un nodoNuevo nodo al árbol
    public void insertar(int valor) {
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;

        if (raiz == null) {
            raiz = nodoNuevo;
        } else {
            Nodo anterior = null;
            Nodo reco = raiz;

            // Buscar la posición correcta para insertar
            while (reco != null) {
                anterior = reco;
                reco = (valor < reco.info) ? reco.izquierdo : reco.derecho;
            }

            // Insertar en la posición encontrada
            if (valor < anterior.info) {
                anterior.izquierdo = nodoNuevo;
            } else {
                anterior.derecho = nodoNuevo;
            }
        }
    }

    // Recorrido preorden (raíz - izquierda - derecha)
    private void imprimirPre(Nodo recorrer) {
        if (recorrer != null) {
            System.out.print(recorrer.info + " ");
            imprimirPre(recorrer.izquierdo);
            imprimirPre(recorrer.derecho);
        }
    }

    public void imprimirPre() {
        imprimirPre(raiz);
        System.out.println();
    }

    // Recorrido inorden (izquierda - raíz - derecha)
    private void imprimirEntre(Nodo recorrer) {
        if (recorrer != null) {
            imprimirEntre(recorrer.izquierdo);
            System.out.print(recorrer.info + " ");
            imprimirEntre(recorrer.derecho);
        }
    }

    public void imprimirEntre() {
        imprimirEntre(raiz);
        System.out.println();
    }

    // Recorrido postorden (izquierda - derecha - raíz)
    private void imprimirPost(Nodo recorrer) {
        if (recorrer != null) {
            imprimirPost(recorrer.izquierdo);
            imprimirPost(recorrer.derecho);
            System.out.print(recorrer.info + " ");
        }
    }

    public void imprimirPost() {
        imprimirPost(raiz);
        System.out.println();
    }

    // Verifica si un valor existe en el árbol
    public boolean existe(int valor) {
        Nodo reco = raiz;
        while (reco != null) {
            if (valor == reco.info)
                return true;
            reco = (valor > reco.info) ? reco.derecho : reco.izquierdo;
        }
        return false;
    }

    // Cuenta todos los nodos del árbol
    private void contarNodos(Nodo recorrer) {
        if (recorrer != null) {
            cantidad++;
            contarNodos(recorrer.izquierdo);
            contarNodos(recorrer.derecho);
        }
    }

    public int cantidad() {
        cantidad = 0;
        contarNodos(raiz);
        return cantidad;
    }

    // Cuenta solo los nodos hoja (sin hijos)
    private void contarNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.izquierdo == null && reco.derecho == null)
                cantidad++;
            contarNodosHoja(reco.izquierdo);
            contarNodosHoja(reco.derecho);
        }
    }

    public int cantidadNodosHoja() {
        cantidad = 0;
        contarNodosHoja(raiz);
        return cantidad;
    }

    // Imprime los nodos en inorden junto al nivel en que se encuentran
    private void imprimirEntreConNivel(Nodo reco, int nivel) {
        if (reco != null) {
            imprimirEntreConNivel(reco.izquierdo, nivel + 1);
            System.out.print(reco.info + " (" + nivel + ") - ");
            imprimirEntreConNivel(reco.derecho, nivel + 1);
        }
    }

    public void imprimirEntreConNivel() {
        imprimirEntreConNivel(raiz, 1);
        System.out.println();
    }

    // Calcula la altura del árbol
    private void calcularAltura(Nodo reco, int nivel) {
        if (reco != null) {
            if (nivel > altura)
                altura = nivel;
            calcularAltura(reco.izquierdo, nivel + 1);
            calcularAltura(reco.derecho, nivel + 1);
        }
    }

    public int retornarAltura() {
        altura = 0;
        calcularAltura(raiz, 1);
        return altura;
    }

    // Muestra el mayor valor del árbol (más a la derecha)
    public void mayorValor() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.derecho != null)
                reco = reco.derecho;
            System.out.println("Mayor valor del árbol: " + reco.info);
        }
    }

    // Muestra el menor valor del árbol (más a la izquierda)
    public void menorValor() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.izquierdo != null)
                reco = reco.izquierdo;
            System.out.println("Menor valor del árbol: " + reco.info);
        }
    }

    // Elimina el nodo con el menor valor del árbol
    public void borrarMenor() {
        if (raiz != null) {
            if (raiz.izquierdo == null) {
                raiz = raiz.derecho;
            } else {
                Nodo padre = raiz;
                Nodo reco = raiz.izquierdo;
                while (reco.izquierdo != null) {
                    padre = reco;
                    reco = reco.izquierdo;
                }
                padre.izquierdo = reco.derecho;
            }
        }
    }

    // Método de prueba en main
    public static void main(String[] args) {
        ArbolBinario2 arbolBinario = new ArbolBinario2();

        // Inserta nodos
        int[] valores = {400, 100, 700, 200, 50, 1200, 15, 75, 300};
        for (int val : valores) {
            arbolBinario.insertar(val);
        }

        // Pruebas de recorridos
        System.out.println("Impresión preorden:");
        arbolBinario.imprimirPre();
        System.out.println("Impresión entreorden:");
        arbolBinario.imprimirEntre();
        System.out.println("Impresión postorden:");
        arbolBinario.imprimirPost();

        // Verifica existencia
        System.out.println(arbolBinario.existe(50) ? "Existe valor 50 en el árbol" : "No existe valor 50 en el árbol");
        System.out.println(arbolBinario.existe(350) ? "Existe valor 350 en el árbol" : "No existe valor 350 en el árbol");

        // Cantidad de nodos y nodos hoja
        System.out.println("Cantidad de nodos del árbol: " + arbolBinario.cantidad());
        System.out.println("Cantidad de nodos HOJA del árbol: " + arbolBinario.cantidadNodosHoja());

        // Inorden con nivel
        System.out.println("Impresión entreorden con nivel:");
        arbolBinario.imprimirEntreConNivel();

        // Altura del árbol
        System.out.println("Altura del árbol: " + arbolBinario.retornarAltura());

        // Mayor y menor valor
        System.out.println("Mayor y menor del árbol:");
        arbolBinario.mayorValor();
        arbolBinario.menorValor();

        // Borrar el menor nodo y volver a imprimir
        arbolBinario.borrarMenor();
        System.out.println("Entreorden después de borrar el menor:");
        arbolBinario.imprimirEntre();
    }
}
