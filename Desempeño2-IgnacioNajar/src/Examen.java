import java.util.Arrays;
import java.util.List;

public class Examen {

	class Nodo {
		int info;
		Nodo izq, der;
	}

	int cant, altura;
	Nodo raiz;

	// 1 => Insertar elementos en el arbol
	public void insertar(int info) {
		// COMPLETAR ESTE METODO
		
	}

	// 2 => Encuentra el menor valor del subArbol derecho
	public void menorValorDerecha() {
		// COMPLETAR ESTE METODO

	}

	// 3 => Encuentra el mayor valor del subArbol izquierdo
	public void mayorValorIzquierda() {
		// COMPLETAR ESTE METODO

	}

	// 4 => Buscar un valor e informar el nivel
	public void existeValorEnNivel(int info) {
		// COMPLETAR ESTE METODO
		
	}


    // 5 => Calcular el total de nodos hoja del arbol
    private void totalNodosHoja(Nodo reco) {	
        // COMPLETAR ESTE METODO
		
	}

    public int totalNodosHoja() {
        cant = 0;
	    // COMPLETAR ESTE METODO
		
	}


	private void imprimirEntre(Nodo reco) {
		if (reco != null) {
			imprimirEntre(reco.izq);
			System.out.print(reco.info + " ");
			imprimirEntre(reco.der);
		}
	}

	public void imprimirEntre() {
		imprimirEntre(raiz);
		System.out.println();
	}

	public static void main(String[] args) {
		Examen abo = new Examen();

		List<Integer> valores = Arrays.asList(400, 100, 700, 200, 50, 1200, 15, 75, 300, 850);
		for (int x : valores) {
			abo.insertar(x);
		}

		System.out.println("1 = Impresion entreorden: ");
		abo.imprimirEntre();

		System.out.println("2 = menor valor del subArbol derecho: ");
		abo.menorValorDerecha();
		
		System.out.println("3 = mayor valor del subArbol izquierdo: ");
		abo.mayorValorIzquierda();

		System.out.println("4 = Buscar valor en el arbol e informar en que nivel existe: ");
		abo.existeValorEnNivel(100);
		abo.existeValorEnNivel(45);

        System.out.println("5 = Total de nodos hoja en el arbol = " + abo.totalNodosHoja());
	}
}
