public class Stack {
    private LinkedList stack;
    private int maxSize;

    public Stack(int maxSize) {
        stack = new LinkedList();
        this.maxSize = maxSize;

    }

    public void push(int number) {
        stack.addFirst(number);

    }

    public int pop() {
        if (isEmpty())
            return -1;
        return stack.removeFirst();
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() == maxSize;
    }

    public void clear() {
        stack.clear();
    }
}

class LinkedList {
    private Node top; // Pointer to the head of the list.

    public LinkedList() {
        top = null;
    }

    /*
     * Enter a data item at the front of the list.
     */

    public void addFirst(int item) {
        Node ptr = new Node(); // Construct a new node - ptr points to it.
        ptr.data = item; // New node's data is the parameter item.
        if (!isEmpty()) {
            ptr.next = top;
        }
        top = ptr;
    }

    /*
     * size()
     *
     * Return the length of the list.
     */

    public int size() {
        Node ptr = top; // A pointer to travel the list.
        int count = 0; // Counts the number of nodes.

        while (ptr != null) // While not at the end of the list.
        {
            count++; // Add this node to the count.
            ptr = ptr.next; // Move to the next node.
        }

        return count; // Return the number of nodes.
    }

    /*
     * removeFirst()
     * removes first element
     */
    public int removeFirst() {
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    /*
     * getFirst()
     * returns first element data
     */
    public int getFirst() {
        return top.data;
    }

    /*
     * isEmpty()
     * returns true if list is empty
     * false if list is not
     */
    public boolean isEmpty() {
        return top == null;
    }

    /*
     * Display the contents of the linked list.
     */

    public void display() {
        Node ptr = top; // Pointer to traverse the list.

        while (ptr != null) { // While not at the end of the list ...
            int data = ptr.data; // Get data of current node.
            System.out.println(data); // Print the data.
            ptr = ptr.next; // Move to the next node.
        }

        System.out.println();
    }

    public void clear() {
        top = null;
    }

    private class Node {
        public int data; // Data stored in the Node.
        public Node next; // Pointer to next Node in the list.
    }
}