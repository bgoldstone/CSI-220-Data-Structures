public class BinarySearchTree {
    private Node root;

    class Node {
        Node right;
        Node left;
        int value;

        public Node(int value) {
            right = null;
            left = null;
            this.value = value;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (isEmpty())
            current = new Node(value);
        else if (current.value > value)
            current.left = insertRecursive(current.left, value);
        else if (current.value < value)
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
