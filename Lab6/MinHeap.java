/**
 * Creates an object of a MinHeap for Dijkstra's Algorithm
 */
public class MinHeap {
    private final ShortestPathNode[] nodeArr;
    private final int size;
    private int currentSize;

    /**
     * Constructor for a {@link MinHeap}.
     */
    public MinHeap(int size) {
        this.size = size;
        nodeArr = new ShortestPathNode[size];
        currentSize = 0;
    }

    /**
     * Function to insert into a {@link MinHeap}.
     *
     * @param node ShortestPathNode to insert.
     */
    public void insert(ShortestPathNode node) {
        if (isEmpty()) {
            currentSize++;
            nodeArr[currentSize] = node;
            return;
        }
        if (currentSize < size) {
            currentSize++;
            nodeArr[currentSize] = node;
            //while child bigger than parent

            int currentNode = currentSize;
            //makes its way up the tree to make sure it is following BinaryTree rules.
            if (currentNode / 2 < 1 || currentNode <= 1) {
                return;
            }
            while (nodeArr[currentNode].distanceFromStart < nodeArr[currentNode / 2].distanceFromStart) {
                swapParentChild(currentNode);
                currentNode /= 2;
                if (currentNode / 2 < 1 || currentNode <= 1) {
                    return;
                }
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
        ShortestPathNode child = nodeArr[currentChild];
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
        return currentSize==0;
    }

    /**
     * Displays all of the {@link ShortestPathNode} in the {@link MinHeap}.
     */
    public void display() {
        for (int i = 1; i <= currentSize; i++) {
            System.out.println("Node Number: " + nodeArr[i].nodeNumber + " Priority: " + nodeArr[i].distanceFromStart);
        }
    }

    /**
     * Gets a ShortestPathNode
     *
     * @param nodeNumber Node Number to get.
     */
    public ShortestPathNode getShortestPathNode(int nodeNumber) {
        if (isEmpty()) {
            System.out.println("Heap is Empty!");
            return null;
        }
        ShortestPathNode current;
        for (int i = 1; i < currentSize + 1; i++) {
            current = nodeArr[i];
            if (current.nodeNumber == nodeNumber) {
                return nodeArr[i];
            }
        }
        System.out.println("Node not found!");
        return null;
    }

    /**
     * Removes Given Node.
     *
     * @return true if node is removed.
     */
    public ShortestPathNode remove() {
        if (!isEmpty()) {
            ShortestPathNode removeVal = nodeArr[1];
            if (removeVal.nodeNumber < 0) {
                return null;
            }
            nodeArr[1] = nodeArr[currentSize];
            nodeArr[currentSize] = null;

            currentSize--;
            downHeap();
            return removeVal;
        }
        return null;
    }

    /**
     * Moves parent and child nodes so that the smaller node is on top.
     */
    public void downHeap() {

        int i = 1;
        while (i < nodeArr.length) {
            ShortestPathNode currentNode = nodeArr[i];
            if (currentNode == null)
                return;
            int leftNode = i * 2;
            int rightNode = i * 2 + 1;
            if (nodeArr[leftNode] == null)
                return;
            if (nodeArr[leftNode].distanceFromStart < currentNode.distanceFromStart && nodeArr[rightNode] == null) {
                swapParentChild(leftNode);
                i *= 2;
            } else if (nodeArr[leftNode].distanceFromStart >= currentNode.distanceFromStart && (nodeArr[rightNode] == null)) {
                return;
            } else if ((nodeArr[rightNode].distanceFromStart < nodeArr[leftNode].distanceFromStart) && (currentNode.distanceFromStart > nodeArr[rightNode].distanceFromStart)) {
                swapParentChild(rightNode);
                i = (i * 2) + 1;
                //if left smaller than right and parent bigger than left
            } else if ((nodeArr[leftNode].distanceFromStart < nodeArr[rightNode].distanceFromStart) && (currentNode.distanceFromStart > nodeArr[leftNode].distanceFromStart)) {
                swapParentChild(leftNode);
                i *= 2;
            } else
                return;
        }
    }

}
