import java.util.*;

public class BFSGraph {
    // Mapa de adyacencia para representar el grafo
    private Map<Integer, List<Integer>> adyacencia;

    // Constructor: inicializa el mapa de adyacencia
    public BFSGraph() {
        adyacencia = new HashMap<>();
    }

    // Método para agregar una arista (conexión) entre dos nodos
    public void agregarArista(int u, int v) {
        adyacencia.putIfAbsent(u, new ArrayList<>());
        adyacencia.putIfAbsent(v, new ArrayList<>());
        adyacencia.get(u).add(v);
        adyacencia.get(v).add(u); // Como es un grafo no dirigido, se agrega en ambos sentidos
    }

    // Método que realiza el recorrido en anchura (BFS) desde un nodo inicial
    public void recorridoBFS(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        System.out.println("Recorrido en anchura (BFS):");

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.println("Visitando nodo: " + nodo);

            for (int vecino : adyacencia.getOrDefault(nodo, new ArrayList<>())) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }

    // Método main para probar el grafo y el recorrido BFS
    public static void main(String[] args) {
        BFSGraph grafo = new BFSGraph();

        // Agregar aristas al grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(2, 6);

        // Ejecutar recorrido BFS desde el nodo 0
        grafo.recorridoBFS(0);
    }
}