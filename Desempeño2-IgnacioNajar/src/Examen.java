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
		Nodo nodoNuevo = new Nodo();
		nodoNuevo.info = info;
		nodoNuevo.der = null;
		nodoNuevo.izq = null;

		if (raiz == null) {
			raiz = nodoNuevo;
		} else {
			Nodo anterior = null;
			Nodo reco = raiz;

			while (reco != null) {
				anterior = reco;
				reco = (info < reco.info) ? reco.izq : reco.der;
			}

			if (info < anterior.info) {
				anterior.izq = nodoNuevo;
			} else {
				anterior.der = nodoNuevo;
			}
		}
	}

	// 2 => Encuentra el menor valor del subArbol derecho
	public void menorValorDerecha() {
		// COMPLETAR ESTE METODO
		if (raiz == null || raiz.der == null) {
			System.out.println("No existe el subarbol derecho o el arbol está vacío");
			return;
		}

		Nodo reco = raiz.der;
		while (reco.izq != null) {
			reco = reco.izq;
		}

		System.out.println(reco.info);
	}

	// 3 => Encuentra el mayor valor del subArbol izquierdo
	public void mayorValorIzquierda() {
		// COMPLETAR ESTE METODO
		if (raiz == null || raiz.izq == null) {
			System.out.println("No existe subarbol izquierdo o el arbol está vacío");
			return;
		}

		Nodo reco = raiz.izq;
		while (reco.der != null) {
			reco = reco.der;
		}

		System.out.println(reco.info);
	}

	// 4 => Buscar un valor e informar el nivel
	public void existeValorEnNivel(int info) {
		if (raiz == null) {
			System.out.println("El arbol está vacío");
			return;
		}
		// COMPLETAR ESTE METODO
		Nodo reco = raiz;
		int nivel = 0;

		while (reco != null) {
			nivel++;
			if (info == reco.info) {
				System.out.println("El nodo con el valor (" + info + ") existe en el nivel " + nivel);
				return;
			}
				
			if (info > reco.info) {
				reco = reco.der;
			} else {
				reco = reco.izq;
			}
		}

		System.out.println("El nodo con el valor (" + info + ") no existe");
		
	}


    // 5 => Calcular el total de nodos hoja del arbol
    private void totalNodosHoja(Nodo reco) {	
        // COMPLETAR ESTE METODO
		if (reco != null) {
			if (reco.izq == null && reco.der == null) {
				cant++;
			}
			
			totalNodosHoja(reco.izq);
			totalNodosHoja(reco.der);
		}
	}

    public int totalNodosHoja() {
        cant = 0;
		totalNodosHoja(raiz);
		return cant;
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
		
		System.out.print("\n2 = menor valor del subArbol derecho: ");
		abo.menorValorDerecha();
		
		
		System.out.print("\n3 = mayor valor del subArbol izquierdo: ");
		abo.mayorValorIzquierda();
		
		System.out.println("\n4 = Buscar valor en el arbol e informar en que nivel existe: ");
		abo.existeValorEnNivel(100);
		abo.existeValorEnNivel(45);
		
        System.out.println("\n5 = Total de nodos hoja en el arbol = " + abo.totalNodosHoja());
	}
}
