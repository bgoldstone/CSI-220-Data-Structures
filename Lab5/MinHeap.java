/**
 * Creates an object of a MinHeap where the smaller the number, the higher the priority.
 */
public class MinHeap {
    private HeapNode root;
    private HeapNode nodeArr[];
    private final int size;
    private int currentSize;

    /**
     * Constructor for a {@link MinHeap}.
     */
    public MinHeap(int size) {
        root = null;
        this.size = size;
        nodeArr = new HeapNode[size + 1];
        currentSize = 1;
    }

    /**
     * Function to insert into a {@link MinHeap}.
     *
     * @param rank the rank of the node.
     * @param name the node's name.
     */
    public void insert(int rank, String name) {
        if (currentSize < size) {
            nodeArr[currentSize] = new HeapNode(rank, name);
            currentSize++;
            //while child bigger than parent
            int currentNode = currentSize;
            //makes its way up the tree to make sure it is following BinaryTree rules.
            while (nodeArr[currentNode].value < nodeArr[currentNode / 2].value) {
                swapParentChildLeft(currentNode);
                currentNode = currentNode / 2;
            }
        } else
            System.out.println("Heap is Full!");
    }

    /**
     * Swaps parent node and right child node.
     *
     * @param current child node.
     */
    public void swapParentChildLeft(int current) {
        HeapNode child = nodeArr[current];
        nodeArr[current] = nodeArr[current / 2];
        nodeArr[current / 2] = child;

    }

    /**
     * Swaps parent node and left child node.
     *
     * @param current child node.
     */
    public void swapParentChildRight(int current) {
        HeapNode child = nodeArr[current];
        nodeArr[current] = nodeArr[current / 2 + 1];
        nodeArr[current / 2 + 1] = child;
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
        displayRecursive(1);
    }

    /**
     * Traverses {@link MinHeap} inOrder.
     *
     * @param current Root node for first iteration.
     * @return {@link HeapNode}.
     */
    public int displayRecursive(int current) {
        if (current >= currentSize)
            return 1;
        displayRecursive(current * 2);
        System.out.println("Guest Name: " + nodeArr[current].name + " Rank: " + nodeArr[current].value);
        displayRecursive((current * 2) + 1);
        return current;
    }

    /**
     * Searches for Node.
     *
     * @param name name(key) to search for.
     */
    public void search(String name) {
        for (HeapNode current : nodeArr) {
            if (current.name.equals(name)) {
                System.out.println("Guest Found!");
                System.out.println("Guest Name: " + current.name + " Rank: " + current.value);
                return;
            }
        }
        System.out.println("Guest not found!");
        return;
    }

    /**
     * Removes Given Node.
     *
     * @return true if node is removed.
     */
    public boolean remove() {
        if (!isEmpty()) {
            HeapNode removeVal = nodeArr[1];
            nodeArr[1] = nodeArr[currentSize];
            currentSize--;
            moveMin(1);
            System.out.println("Guest Name: " + removeVal.name + " Priority: " + removeVal.value);
            return true;
        }
        return false;
    }

    /**
     * Moves parent and child nodes so that the smaller node is on top.
     *
     * @param current Node to check. Starting out this is the first node.
     */
    public void moveMin(int current) {

        HeapNode currentNode = nodeArr[current];
        HeapNode leftNode = nodeArr[current / 2];
        HeapNode rightNode = nodeArr[current / 2 + 1];
        //if current node is not a leaf
        if (current > currentSize || current < (currentSize / 2)) {
            //if parent bigger than any of its children
            if ((currentNode.value > leftNode.value) || (currentNode.value > rightNode.value)) {
                //if left node smaller than left node move left node up and check its children.
                if (leftNode.value < rightNode.value) {
                    swapParentChildLeft(current / 2);
                    moveMin(current / 2);
                    //else right is bigger than left or equal to.
                } else {
                    swapParentChildRight(current / 2 + 1);
                    moveMin(current / 2 + 1);
                }

            }

        }
    }

    /**
     * Creates an object of a {@link HeapNode}.
     */
    class HeapNode {
        int value;
        String name;

        /**
         * Constructor for a {@link HeapNode}.
         *
         * @param value the data or value of the {@link HeapNode}.
         * @param name  the name of the Guest.
         */
        public HeapNode(int value, String name) {
            this.value = value;
            this.name = name;
        }

    }
}
