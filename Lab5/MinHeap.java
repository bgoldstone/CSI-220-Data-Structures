/**
 * Creates an object of a MinHeap where the smaller the number, the higher the priority.
 */
public class MinHeap {
    private HeapNode nodeArr[];
    private final int size;
    private int currentSize;

    /**
     * Constructor for a {@link MinHeap}.
     */
    public MinHeap(int size) {
        this.size = size + 1;
        nodeArr = new HeapNode[size];
        currentSize = 0;
    }

    /**
     * Function to insert into a {@link MinHeap}.
     *
     * @param rank the rank of the node.
     * @param name the node's name.
     */
    public void insert(int rank, String name) {
        if (isEmpty()) {
            currentSize++;
            nodeArr[currentSize] = new HeapNode(rank, name);
            return;
        }
        if (currentSize < size) {
            currentSize++;
            nodeArr[currentSize] = new HeapNode(rank, name);
            //while child bigger than parent
            int currentNode = currentSize;
            //makes its way up the tree to make sure it is following BinaryTree rules.
            if (currentNode / 2 < 1 || currentNode / 2 < 1) {
                return;
            }
            while (nodeArr[currentNode].value < nodeArr[currentNode / 2].value) {
                if (currentNode % 2 == 0)
                    swapParentChild(currentNode);
                else if (currentNode % 2 == 1)
                    swapParentChild(currentNode);
                currentNode = currentNode / 2;
            }
        } else
            System.out.println("Heap is Full!");
    }

    /**
     * Swaps parent node and child node.
     *
     * @param currentChild child node.
     */
    public void swapParentChild(int currentChild) {
        HeapNode child = nodeArr[currentChild];
        nodeArr[currentChild] = nodeArr[currentChild / 2];
        //parent Node
        nodeArr[currentChild / 2] = child;

    }

    /**
     * Gets if {@link MinHeap} is Empty
     *
     * @return true if {@link MinHeap} is empty.
     */
    public boolean isEmpty() {
        return nodeArr[1] == null;
    }

    /**
     * Displays all of the {@link HeapNode} in the {@link MinHeap}.
     */
    public void display() {
        for (int i = 1; i < nodeArr.length; i++) {
            if (nodeArr[i] == null)
                break;
            System.out.println(nodeArr[i].toString());
        }
    }

    /**
     * Searches for Node.
     *
     * @param name name(key) to search for.
     */
    public boolean search(String name) {
        if (isEmpty()) {
            System.out.println("Heap is Empty!");
            return false;
        }
        HeapNode current;
        for (int i = 1; i < currentSize + 1; i++) {
            current = nodeArr[i];
            if (current.name.equals(name)) {
                System.out.println("Guest Found!");
                System.out.println("Guest Name: " + current.name + " Rank: " + current.value);
                return true;
            }
        }
        System.out.println("Guest not found!");
        return false;
    }

    /**
     * Removes Given Node.
     *
     * @return true if node is removed.
     */
    public boolean remove() {
        if (!isEmpty()) {
            HeapNode removeVal = nodeArr[1];
            if (removeVal.name == "") {
                currentSize--;
                return false;
            }
            nodeArr[1] = nodeArr[currentSize];
            nodeArr[currentSize] = null;

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
        if (currentNode == null)
            return;
        HeapNode leftNode = nodeArr[current / 2];
        HeapNode rightNode = nodeArr[current / 2 + 1];
        /* if left child is greater than or equal to size and
         * if right child is bigger or equal to size, it must be a leaf.
         */
        if (!(current / 2 >= currentSize && current / 2 + 1 >= currentSize)) {

            if (leftNode == null || rightNode == null)
                return;
            //if parent bigger than any of its children
            if ((currentNode.value > leftNode.value) || (currentNode.value > rightNode.value)) {
                //if left node smaller than left node move left node up and check its children.
                if (leftNode.value < rightNode.value) {
                    swapParentChild(current);
                    moveMin(current * 2);
                    //else right is bigger than left or equal to.
                } else {
                    swapParentChild(current);
                    moveMin((current * 2) + 1);
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

        public String toString() {
            return "Guest Name: " + name + " Priority: " + value;
        }

    }
}
