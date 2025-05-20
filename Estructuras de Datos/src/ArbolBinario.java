public class ArbolBinario {

	class Nodo {
		int info;
		Nodo izquierda, derecha;
	}

	private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

	// Método para insertar un valor en el árbol
	public void insertar(int info) {
		Nodo nuevo = new Nodo();
		nuevo.info = info;

		if (raiz == null) {
			raiz = nuevo;
			return;
		}

		Nodo anterior = null;
		Nodo actual = raiz;

		while (actual != null) {
			anterior = actual;

			if (info == actual.info) {
				System.out.println("Valor duplicado: " + info);
				return;
			} else if (info < actual.info) {
				actual = actual.izquierda;
			} else {
				actual = actual.derecha;
			}
		}

		if (info < anterior.info) {
			anterior.izquierda = nuevo;
		} else {
			anterior.derecha = nuevo;
		}
	}

	// Recorrido preorden
	private void imprimirPre(Nodo nodo) {
		if (nodo != null) {
			System.out.print(nodo.info + " ");
			imprimirPre(nodo.izquierda);
			imprimirPre(nodo.derecha);
		}
	}

	public void imprimirPre() {
		imprimirPre(raiz);
		System.out.println();
	}

	// Recorrido entreorden
	private void imprimirEntre(Nodo nodo) {
		if (nodo != null) {
			imprimirEntre(nodo.izquierda);
			System.out.print(nodo.info + " ");
			imprimirEntre(nodo.derecha);
		}
	}

	public void imprimirEntre() {
		imprimirEntre(raiz);
		System.out.println();
	}

	// Recorrido postorden
	private void imprimirPost(Nodo nodo) {
		if (nodo != null) {
			imprimirPost(nodo.izquierda);
			imprimirPost(nodo.derecha);
			System.out.print(nodo.info + " ");
		}
	}

	public void imprimirPost() {
		imprimirPost(raiz);
		System.out.println();
	}

	// Buscar un valor en el árbol
	public boolean buscar(int x) {
		Nodo actual = raiz;

		while (actual != null) {
			if (x == actual.info) {
				return true;
			} else if (x < actual.info) {
				actual = actual.izquierda;
			} else {
				actual = actual.derecha;
			}
		}

		return false;
	}

	// Contar cantidad de nodos
	private int contarNodos(Nodo nodo) {
		if (nodo == null) return 0;
		return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
	}

	public int contarNodos() {
		return contarNodos(raiz);
	}

	// Calcular altura del árbol
	private int altura(Nodo nodo) {
		if (nodo == null) return 0;
		int altIzq = altura(nodo.izquierda);
		int altDer = altura(nodo.derecha);
		return 1 + Math.max(altIzq, altDer);
	}

	public int altura() {
		return altura(raiz);
	}

	// Verificar si el árbol está balanceado
	private boolean esBalanceado(Nodo nodo) {
		if (nodo == null) return true;

		int altIzq = altura(nodo.izquierda);
		int altDer = altura(nodo.derecha);

		if (Math.abs(altIzq - altDer) > 1) return false;

		return esBalanceado(nodo.izquierda) && esBalanceado(nodo.derecha);
	}

	public boolean esBalanceado() {
		return esBalanceado(raiz);
	}

	// Invertir (espejar) el árbol binario
	private void invertir(Nodo nodo) {
		if (nodo != null) {
			// Intercambiar hijos
			Nodo temp = nodo.izquierda;
			nodo.izquierda = nodo.derecha;
			nodo.derecha = temp;

			invertir(nodo.izquierda);
			invertir(nodo.derecha);
		}
	}

	public void invertir() {
		invertir(raiz);
	}

	// Método main para probar el árbol
	public static void main(String[] args) {
		ArbolBinario arbol = new ArbolBinario();

		// Inserciones
		arbol.insertar(400);
		arbol.insertar(100);
		arbol.insertar(700);
		arbol.insertar(200);
		arbol.insertar(50);
		arbol.insertar(1200);
		arbol.insertar(15);
		arbol.insertar(75);
		arbol.insertar(300);
		arbol.insertar(700); // duplicado

		// Recorridos originales
		System.out.println("Recorrido Entre-orden ORIGINAL:");
		arbol.imprimirEntre();

		System.out.println("Recorrido Pre-orden:");
		arbol.imprimirPre();

		System.out.println("Recorrido Post-orden:");
		arbol.imprimirPost();

		// Búsqueda
		System.out.println("¿Está el valor 75?: " + arbol.buscar(75));
		System.out.println("¿Está el valor 999?: " + arbol.buscar(999));

		// Información adicional
		System.out.println("Cantidad de nodos: " + arbol.contarNodos());
		System.out.println("Altura del árbol: " + arbol.altura());
		System.out.println("¿Está balanceado?: " + arbol.esBalanceado());

		// Inversión
		System.out.println("Invirtiendo el árbol...");
		arbol.invertir();

		// Recorridos luego de invertir
		System.out.println("Recorrido Entre-orden INVERTIDO:");
		arbol.imprimirEntre();
	}
}