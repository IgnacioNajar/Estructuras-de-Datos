public class ReverseBinaryTree {

    // Clase interna para representar un nodo del árbol
    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // Raíz del árbol
    Nodo raiz;

    // Método que invierte recursivamente el árbol binario
    void invertir(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        // Intercambiar los hijos izquierdo y derecho
        Nodo temp = nodo.izquierdo;
        nodo.izquierdo = nodo.derecho;
        nodo.derecho = temp;

        // Llamadas recursivas en los subárboles
        invertir(nodo.izquierdo);
        invertir(nodo.derecho);
    }

    // Método para imprimir el árbol en preorden
    void imprimirPreorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        System.out.print(nodo.valor + " ");
        imprimirPreorden(nodo.izquierdo);
        imprimirPreorden(nodo.derecho);
    }

    public static void main(String[] args) {
        ReverseBinaryTree arbol = new ReverseBinaryTree();

        // Crear árbol binario de ejemplo:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(3);
        arbol.raiz.izquierdo.izquierdo = new Nodo(4);
        arbol.raiz.izquierdo.derecho = new Nodo(5);
        arbol.raiz.derecho.izquierdo = new Nodo(6);
        arbol.raiz.derecho.derecho = new Nodo(7);

        System.out.println("Árbol original en preorden:");
        arbol.imprimirPreorden(arbol.raiz);

        // Invertir el árbol
        arbol.invertir(arbol.raiz);

        System.out.println("\nÁrbol invertido en preorden:");
        arbol.imprimirPreorden(arbol.raiz);
    }
}
