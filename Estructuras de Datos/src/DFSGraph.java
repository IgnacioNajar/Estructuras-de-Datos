import java.util.*;

public class DFSGraph {
    // Mapa de adyacencia para representar el grafo
    private Map<Integer, List<Integer>> adyacencia;

    // Constructor: inicializa el mapa de adyacencia
    public DFSGraph() {
        adyacencia = new HashMap<>();
    }

    // Método para agregar una arista (conexión) entre dos nodos
    public void agregarArista(int u, int v) {
        adyacencia.putIfAbsent(u, new ArrayList<>());
        adyacencia.putIfAbsent(v, new ArrayList<>());
        adyacencia.get(u).add(v);
        adyacencia.get(v).add(u); // Como es un grafo no dirigido, se agrega en ambos sentidos
    }

    // Método que realiza el recorrido en profundidad (DFS) desde un nodo inicial
    public void recorridoDFS(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido en profundidad (DFS):");
        dfsUtil(inicio, visitados);
    }

    // Método auxiliar recursivo que realiza el recorrido DFS
    private void dfsUtil(int nodo, Set<Integer> visitados) {
        visitados.add(nodo);
        System.out.println("Visitando nodo: " + nodo);

        for (int vecino : adyacencia.getOrDefault(nodo, new ArrayList<>())) {
            if (!visitados.contains(vecino)) {
                dfsUtil(vecino, visitados);
            }
        }
    }

    // Método principal para probar el grafo y el recorrido DFS
    public static void main(String[] args) {
        DFSGraph grafo = new DFSGraph();

        // Agregar aristas al grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(2, 6);

        // Ejecutar recorrido DFS desde el nodo 0
        grafo.recorridoDFS(0);
    }
}