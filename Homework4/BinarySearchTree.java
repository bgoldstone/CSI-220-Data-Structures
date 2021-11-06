public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    class Node {
        Node right;
        Node left;
        T value;

        public Node(T value) {
            right = null;
            left = null;
            this.value = value;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    //inserts element into tree
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node x, T value) {
        if (isEmpty())
            x = new Node(value);
        else if (x.value.compareTo(value) > 0)
            x.left = insertRecursive(x.left, value);
        else if (x.value.compareTo(value) < 0)
            x.right = insertRecursive(x.right, value);
        return x;
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node x, T value) {
        //base case
        if (x == null)
            return x;
            //if value smaller than left
        else if (x.value.compareTo(value) < 0)
            deleteRecursive(x.left, value);
            //if value smaller than left
        else if (x.value.compareTo(value) > 0)
            deleteRecursive(x.right, value);
            //else successor time!
        else {
            //if node has one or zero children
            if (x.left == null)
                return x.right;
            else if (x.right == null)
                return x.left;
            //if node has two children get the smallest value on right side of tree
            x.value = getSuccessor(x.right);

            //deletes successor, as it is moved
            x.right = deleteRecursive(x.right, x.value);
        }
        return x;
    }

    /**
     * Gets the smallest value on right side of tree
     */
    private T getSuccessor(Node current) {
        T successor = current.value;
        while (current.left != null) {
            successor = current.left.value;
            current = current.left;
        }
        return successor;
    }

    public void print(char c) {
        switch (c) {
            case '1' -> printPreOrderRecursive(root);
            case '2' -> printPostOrderRecursive(root);
            case '3' -> printInOrderRecursive(root);
            default -> System.out.println("Invalid Option!");
        }
    }

    private void printInOrderRecursive(Node x) {
        if (x == null) return;
        printInOrderRecursive(x.left);
        System.out.println(x.value);
        printInOrderRecursive(x.right);
    }

    private void printPostOrderRecursive(Node x) {
        if (x == null) return;
        printPostOrderRecursive(x.left);
        printPostOrderRecursive(x.right);
        System.out.println(x.value);

    }

    private void printPreOrderRecursive(Node x) {
        if (x == null) return;
        System.out.println(x.value);
        printPreOrderRecursive(x.left);
        printPreOrderRecursive(x.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
