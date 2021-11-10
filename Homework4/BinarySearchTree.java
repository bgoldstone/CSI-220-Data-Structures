public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int depth;
    private boolean isInTree;

    /**
     * Binary Search Tree Node.
     */
    class Node {
        Node right;
        Node left;
        T value;

        /**
         * Node constructor.
         *
         * @param value Node value.
         */
        public Node(T value) {
            right = null;
            left = null;
            this.value = value;
        }
    }

    /**
     * Binary Search Tree Constructor.
     */
    public BinarySearchTree() {
        root = null;
    }

    //Time Complexity is O(lgn)

    /**
     * Inserts element into tree.
     *
     * @param value value to insert.
     */
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    /**
     * Inserts a new node recursively.
     *
     * @param x     root Node.
     * @param value value to insert.
     * @return root Node
     */
    private Node insertRecursive(Node x, T value) {
        if (x == null)
            x = new Node(value);
        else if (x.value.compareTo(value) > 0)
            x.left = insertRecursive(x.left, value);
        else if (x.value.compareTo(value) < 0)
            x.right = insertRecursive(x.right, value);
        return x;
    }

    //Time Complexity is O(lgn)

    /**
     * Deletes Node in BinarySearchTree.
     *
     * @param value value to delete.
     */
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    /**
     * Deletes Node recursively.
     *
     * @param x     Root Node.
     * @param value value to delete.
     * @return Node
     */
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

    //Time Complexity is O(lgn)

    /**
     * Finds a node and returns true if in BinarySearchTree.
     */
    public boolean findNode(T value) {
        isInTree = false;
        findNodeRecursive(root, value);
        return isInTree;
    }

    /**
     * finds Node recursively.
     *
     * @param x     root Node.
     * @param value value to find.
     */
    private void findNodeRecursive(Node x, T value) {
        if (x == null || isInTree)
            return;
        findNodeRecursive(x.left, value);
        if (x.value.equals(value)) {
            isInTree = true;
            return;
        }
        findNodeRecursive(x.right, value);
        if (x.value.equals(value))
            isInTree = true;
    }

    /**
     * Prints Binary search tree
     *
     * @param c '1' for PreOrder, '2' for InOrder, '3' for PostOrder.
     */
    public void print(char c) {
        switch (c) {
            case '1' -> printPreOrderRecursive(root);
            case '2' -> printInOrderRecursive(root);
            case '3' -> printPostOrderRecursive(root);
            default -> System.out.println("Invalid Option!");
        }
    }

    //Time Complexity is O(lgn)

    /**
     * Gets Depth of the Node
     *
     * @param value value to find.
     * @return int depth of given Node value.
     */
    public int getDepthNode(T value) {
        depth = 0;
        getDepthNodeRecursive(root, value);
        return depth;
    }

    /**
     * Gets Depth of Node Recursive.
     *
     * @param x     root Node.
     * @param value value to find.
     * @return Node.
     */
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

    //Time Complexity is O(n)

    /**
     * Gets depth of the tree.
     *
     * @return int depth of the tree.
     */
    public int getDepthTree() {
        if (root == null)
            return -1;
        else {
            return getDepthTreeRecursive(root);
        }
    }

    /**
     * Gets depth of the tree recursively.
     *
     * @param x root Node.
     * @return int depth of the tree.
     */
    private int getDepthTreeRecursive(Node x) {
        int leftMax = getDepthTreeRecursive(x.left);
        int rightMax = getDepthTreeRecursive(x.right);
        if (leftMax > rightMax)
            return leftMax + 1;
        else
            return rightMax + 1;

    }

    /**
     * Prints PreOrder of Binary Tree.
     *
     * @param x root Node.
     */
    private void printPreOrderRecursive(Node x) {
        if (x == null) return;
        System.out.println(x.value);
        printPreOrderRecursive(x.left);
        printPreOrderRecursive(x.right);
    }

    /**
     * Prints InOrder of Binary Tree.
     *
     * @param x root Node.
     */
    private void printInOrderRecursive(Node x) {
        if (x == null) return;
        printInOrderRecursive(x.left);
        System.out.println(x.value);
        printInOrderRecursive(x.right);
    }

    /**
     * Prints PostOrder of Binary Tree.
     *
     * @param x root Node.
     */
    private void printPostOrderRecursive(Node x) {
        if (x == null) return;
        printPostOrderRecursive(x.left);
        printPostOrderRecursive(x.right);
        System.out.println(x.value);

    }

    /**
     * Swaps left and right tree items.
     */
    public void SwapTree() {
        SwapTreeRecursive(root);
    }

    //Time Complexity O(n)

    /**
     * Swaps left and right tree items recursively.
     *
     * @param x root Node.
     * @return Node.
     */
    private Node SwapTreeRecursive(Node x) {
        if (x == null)
            return x;
        else {
            SwapTreeRecursive(x.left);
            Node swap = x.left;
            x.left = x.right;
            x.right = swap;
            SwapTreeRecursive(x.right);
            swap = x.left;
            x.left = x.right;
            x.right = swap;
        }
        return x;
    }
}
