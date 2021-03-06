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
            if (!isEmpty()) {
                int currentNode = currentSize;
                //makes its way up the tree to make sure it is following BinaryTree rules.
                if (currentNode / 2 < 1 || currentNode <= 1) {
                    return;
                }
                while (nodeArr[currentNode].value < nodeArr[currentNode / 2].value) {
                    swapParentChild(currentNode);
                    currentNode /= 2;
                    if (currentNode / 2 < 1 || !(currentNode > 1)) {
                        return;
                    }
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
        for (int i = 1; i <= currentSize; i++) {
            System.out.println("Guest Name: " + nodeArr[i].name + " Priority: " + nodeArr[i].value);
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
            downHeap();
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
    public void downHeap(){

       int i = 1;
       while(i < nodeArr.length) {
        	 HeapNode currentNode = nodeArr[i];
             if (currentNode == null)
                 return;
             int leftNode = i * 2;
             int rightNode = i * 2 + 1;
             if (nodeArr[leftNode] == null)
                 return;
             if(nodeArr[leftNode].value < currentNode.value && nodeArr[rightNode] == null) {
            	 swapParentChild(leftNode);
            	 i*=2;
             } else if(nodeArr[leftNode].value >= currentNode.value &&(nodeArr[rightNode] == null)) {
            	 return;
             }
             else if ((nodeArr[rightNode].value < nodeArr[leftNode].value) && (currentNode.value > nodeArr[rightNode].value)) {
                 swapParentChild(rightNode);
                 i = (i*2) +1;
                 //if left smaller than right and parent bigger than left
             } else if ((nodeArr[leftNode].value < nodeArr[rightNode].value) && (currentNode.value > nodeArr[leftNode].value)) {
                 swapParentChild(leftNode);
                 i*=2;
             } else
                 return;
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
