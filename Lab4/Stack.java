public class Stack<T> implements StackInterface<T> {
    private LinkedList<T> stack;
    private int maxSize;

    public Stack(int maxSize) {
        stack = new LinkedList<>();
        this.maxSize = maxSize;

    }

    public void push(T number) {
        stack.addFirst(number);

    }

    public T pop() {
        if (isEmpty())
            return null;
        return stack.removeFirst();
    }

    public T peek() {
        if (isEmpty())
            return null;
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

class LinkedList<T> {
    private Node head; // Pointer to the head of the list.

    public LinkedList() {
        head = null;
    }

    /*
     * Enter a data item at the front of the list.
     */

    public void addFirst(T item) {
        Node ptr = new Node(); // Construct a new node - ptr points to it.
        ptr.data = item; // New node's data is the parameter item.
        if (!isEmpty()) {
            ptr.next = head;
        }
        head = ptr;
    }

    /*
     * size()
     *
     * Return the length of the list.
     */

    public int size() {
        Node ptr = head; // A pointer to travel the list.
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
    public T removeFirst() {
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    /*
     * getFirst()
     * returns first element data
     */
    public T getFirst() {
        return head.data;
    }

    /*
     * isEmpty()
     * returns true if list is empty
     * false if list is not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /*
     * Display the contents of the linked list.
     */

    public void display() {
        Node ptr = head; // Pointer to traverse the list.

        while (ptr != null) { // While not at the end of the list ...
            T data = ptr.data; // Get data of current node.
            System.out.println(data.toString()); // Print the data.
            ptr = ptr.next; // Move to the next node.
        }

        System.out.println();
    }

    public void clear() {
        head = null;
    }

    private class Node {
        public T data; // Data stored in the Node.
        public Node next; // Pointer to next Node in the list.
    }
}