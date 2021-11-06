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

    private Node insertRecursive(Node current, T value) {
        if (isEmpty())
            current = new Node(value);
        else if (current.value.compareTo(value) > 0)
            current.left = insertRecursive(current.left, value);
        else if (current.value.compareTo(value) < 0)
            current.right = insertRecursive(current.right, value);
        return current;
    }

    public void delete(T value){
        root = deleteRecursive(value, root);
    }
    private Node deleteRecursive(T value, Node current){
        if(current == null)
            return root;
        else if (current.value.compareTo(value) < 0)
            deleteRecursive(value,current.left);
        else if(current.value.compareTo(value) > 0)
            deleteRecursive(value,current.right);
        else{
            if(current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;

            root.value = getSuccessor(root.right);

            root.right = deleteRecursive(root.value, root.right);
        }
        return root;
    }
    private T getSuccessor(Node current){
        T successor = current.value;
        while(current.left != null){
            successor = current.left.value;
            current = current.left;
        }
        return successor;
    }

    public void print(char c) {
        switch(c) {
            case '1':
                printPreOrderResursive(root);
                break;
            case '2':
                printPostOrderResursive(root);
                break;
            case '3':
                printInOrderResursive(root);
                break;
            default:
                System.out.println("Invalid Option!");
                break;
        }
    }

    private void printInOrderResursive(Node x) {
        if (x == null) return;
        printInOrderResursive(x.left);
        System.out.println(x.value);
        printInOrderResursive(x.right);
    }

    private void printPostOrderResursive(Node x) {
        if (x == null) return;
        printPostOrderResursive(x.left);
        printPostOrderResursive(x.right);
        System.out.println(x.value);

    }

    private void printPreOrderResursive(Node x) {
        if (x == null) return;
        System.out.println(x.value);
        printPreOrderResursive(x.left);
        printPreOrderResursive(x.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
