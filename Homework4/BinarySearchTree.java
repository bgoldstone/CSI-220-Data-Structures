public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int depth;
    private boolean isInTree;

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
        if (x == null)
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

    public boolean findNode(T value) {
        isInTree = false;
        findNodeRecursive(root,value);
        return isInTree;
    }

    private void findNodeRecursive(Node x, T value) {
        if (x == null)
            return;
        findNodeRecursive(x.left, value);
        if (x.value.equals(value)) {
            isInTree = true;
            return;
        }
        findNodeRecursive(x.right, value);
    }

    public void print(char c) {
        switch (c) {
            case '1' -> printPreOrderRecursive(root);
            case '2' -> printInOrderRecursive(root);
            case '3' -> printPostOrderRecursive(root);
            default -> System.out.println("Invalid Option!");
        }
    }

    public int getDepthNode(T value) {
        depth = 0;
        getDepthNodeRecursive(root, value);
        return depth;
    }

    private Node getDepthNodeRecursive(Node x, T value) {
        if (x.value == value)
            return x;
        else if (x.value.compareTo(value) > 0) {
            depth++;
            x.left = getDepthNodeRecursive(x.left, value);
        } else if (x.value.compareTo(value) < 0) {
            depth++;
            x.right = getDepthNodeRecursive(x.right, value);
        }
        return x;
    }

    public int getDepthTree() {
        depth = 0;
        if (root == null)
            return -1;
        getDepthTreeRecursive(root);
        return depth;
    }

    private Node getDepthTreeRecursive(Node x) {
        return x;
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
