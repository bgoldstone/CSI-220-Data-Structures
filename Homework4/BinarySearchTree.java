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

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, T value) {
        if (isEmpty())
            current = new Node(value);
        else if (current.value.compareTo(value) > 0)
            current.left = insertRecursive(current.left, value);
        else if (current.value.compareTo(value) < 0)
            current.right = insertRecursive(current.right, value);
        return current;
    }

    public void inOrder() {
        inOrderResursive(root);
    }

    private void inOrderResursive(Node x) {
        if (x == null) return;
        inOrderResursive(x.left);
        System.out.println(x.value);
        inOrderResursive(x.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
