import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            this.data = value;
        }
    }

    // Crear árbol ejemplo
    public static Node createSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    // Invertir el árbol
    public static Node invert(Node root) {
        if (root == null) return null;
        Node left = invert(root.left);
        Node right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // Obtener altura del árbol
    public static int getHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Imprimir el árbol en forma de estructura gráfica
    public static void printTree(Node root) {
        int maxLevel = getHeight(root);
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        printTreeLevel(currentLevel, 1, maxLevel);
    }

    private static void printTreeLevel(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        // Dibujar las líneas "/ \"
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines * 2 + i + 1);
                    continue;
                }
                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i * 2 - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines * 2 - i);
            }
            System.out.println();
        }

        printTreeLevel(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private static boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) {
            if (node != null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = createSampleTree();

        System.out.println("Árbol original:");
        printTree(root);

        invert(root);
        System.out.println("\nÁrbol invertido:");
        printTree(root);
    }
}
