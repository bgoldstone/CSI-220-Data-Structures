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

    public void insert(int value, String name) {
        if (currentSize < size) {
            nodeArr[currentSize] = new HeapNode(value, name);
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
     * Sorts parent and child nodes.
     *
     * @param current child to swap.
     */
    public void swapParentChildLeft(int current) {
        HeapNode child = nodeArr[current];
        nodeArr[current] = nodeArr[current / 2];
        nodeArr[current / 2] = child;

    }

    public void swapParentChildRight(int current) {
        HeapNode child = nodeArr[current];
        nodeArr[current] = nodeArr[current / 2 + 1];
        nodeArr[current / 2 + 1] = child;
    }


    /**
     * Function to insert into a {@link MinHeap}.
     *
     * @param current    the current node.
     * @param insertNode the node to insert.
     */

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
                    swapParentChildLeft(current);
                    moveMin(current / 2);
                    //else right is bigger than left or equal to.
                } else {
                    swapParentChildRight(current);
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
        int left;
        int right;

        /**
         * Constructor for a {@link HeapNode}.
         *
         * @param value the data or value of the {@link HeapNode}.
         * @param name  the name of the Guest.
         */
        public HeapNode(int value, String name) {
            this.value = value;
            this.name = name;
            this.left = 2 * currentSize;
            this.right = (2 * currentSize) + 1;
        }

    }
}
