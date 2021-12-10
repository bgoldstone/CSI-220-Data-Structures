/**
 * An implementation of a Stack using a LinkedList.
 */
public class Stack {
    private LinkedList stack;
    private int maxSize;

    /**
     * A constructor for a {@link Stack}.
     *
     * @param maxSize Maximum size of a {@link Stack}.
     */
    public Stack(int maxSize) {
        stack = new LinkedList();
        this.maxSize = maxSize;

    }

    /**
     * Pushes an item into a Stack.
     *
     * @param number number to push in the Stack.
     */
    public void push(int number) {
        stack.addFirst(number);

    }

    /**
     * Pops an item into a Stack.
     *
     * @return Removed item from the Stack.
     */
    public int pop() {
        if (isEmpty())
            return -1;
        return stack.removeFirst();
    }

    /**
     * Peeks first item from the Stack.
     *
     * @return First item from the Stack.
     */
    public int peek() {
        if (isEmpty())
            return -1;
        return stack.getFirst();
    }

    /**
     * Checks if Stack is empty.
     *
     * @return true if empty.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Checks if Stack is Full.
     */
    public boolean isFull() {
        return stack.size() == maxSize;
    }

    /**
     * Clears the stack.
     */
    public void clear() {
        stack.clear();
    }
}

/**
 * An implementation of a LinkedList.
 */
class LinkedList {
    private Node top; // Pointer to the head of the list.

    /**
     * Constructor for a {@link LinkedList}.
     */
    public LinkedList() {
        top = null;
    }

    /**
     * Enter a data item at the front of the list.
     *
     * @param item item to add to the front of the list.
     */
    public void addFirst(int item) {
        Node ptr = new Node(); // Construct a new node - ptr points to it.
        ptr.data = item; // New node's data is the parameter item.
        if (!isEmpty()) {
            ptr.next = top;
        }
        top = ptr;
    }

    /**
     * Gets Size of the list.
     *
     * @return the length of the list.
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

    /**
     * Removes the first element.
     *
     * @return first element.
     */
    public int removeFirst() {
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    /**
     * Gets the first Element
     *
     * @return the first element data
     */
    public int getFirst() {
        return top.data;
    }

    /**
     * Checks if list is empty.
     *
     * @return true if list is empty
     * false if list is not
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
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

    /**
     * Clears the LinkedList.
     */
    public void clear() {
        top = null;
    }

    /**
     * Node Class.
     */
    private class Node {
        public int data; // Data stored in the Node.
        public Node next; // Pointer to next Node in the list.
    }
}