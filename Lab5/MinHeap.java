/**
 * Creates an object of a MinHeap where the smaller the number, the higher the priority.
 */
public class MinHeap {
    private HeapNode root;

    /**
     * Constructor for a {@link MinHeap}.
     */
    public MinHeap() {
        root = null;
    }

    /**
     * Function to insert into a {@link MinHeap}.
     *
     * @param value the value or value of the node.
     * @param name  the name of the Guest.
     */
    public HeapNode insert(int value, String name) {
        if (isEmpty()) {
            return new HeapNode(value, name);
        } else {
            return null;
        }
    }

    /**
     * Gets if {@link MinHeap} is Empty
     *
     * @return true if {@link MinHeap} is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Displays all of the {@link HeapNode} in the {@link MinHeap}.
     */
    public void display() {
        displayRecursive(root);
    }

    /**
     * Traverses {@link MinHeap} inOrder.
     *
     * @param current Root node for first iteration.
     * @return {@link HeapNode}.
     */
    public HeapNode displayRecursive(HeapNode current) {
        if (root == null)
            return current;
        displayRecursive(current.left);
        System.out.println("Guest Name: " + current.name + "Priority: " + current.value);
        displayRecursive(current.right);
        return current;
    }

    /**
     * Creates an object of a {@link HeapNode}.
     */
    class HeapNode {
        int value;
        String name;
        HeapNode left;
        HeapNode right;

        /**
         * Constructor for a {@link HeapNode}.
         *
         * @param value the data or value of the {@link HeapNode}.
         * @param name   the name of the Guest.
         */
        public HeapNode(int value, String name) {
            this.value = value;
            this.name = name;
            this.left = null;
            this.right = null;
        }

        /**
         * Constructor for a {@link HeapNode}.
         *
         * @param value the data or value of the {@link HeapNode}.
         * @param name  the name of the Guest.
         * @param left  the node's left {@link HeapNode}.
         * @param right the node's right {@link HeapNode}.
         */
        public HeapNode(int value, String name, HeapNode left, HeapNode right) {
            this.value = value;
            this.name = name;
            this.left = left;
            this.right = right;
        }

    }
}
