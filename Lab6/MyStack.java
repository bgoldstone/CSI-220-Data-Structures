/**
 * An implementation of a Stack using a LinkedList.
 */
public class MyStack<T> {
    private MyLinkedList<T> stackLL;

    /**
     * A constructor for a {@link MyStack}.
     *
     * @param maxSize Maximum size of a {@link MyStack}.
     */
    public MyStack() {
        stackLL = new MyLinkedList<>();

    }

    /**
     * Pushes an item into a Stack.
     *
     * @param object object to push in the Stack.
     */
    public void push(T object) {
        stackLL.push(object);

    }

    /**
     * Pops an item into a Stack.
     *
     * @return Removed item from the Stack.
     */
    public T pop() {
        if (isEmpty())
            return null;
        return (T) stackLL.pop();
    }

    /**
     * Peeks first item from the Stack.
     *
     * @return First item from the Stack.
     */
    public T peek() {
        if (isEmpty())
            return null;
        return (T) stackLL.peek();
    }

    /**
     * Checks if Stack is empty.
     *
     * @return true if empty.
     */
    public boolean isEmpty() {
        return stackLL.isEmpty();
    }

    /**
     * Clears the stack.
     */
    public void clear() {
        stackLL.clear();
    }
}

/**
 * An implementation of a LinkedList.
 */
class MyLinkedList<T> {
    private Node<T> top; // Pointer to the head of the list.

    /**
     * Constructor for a {@link MyLinkedList}.
     */
    public MyLinkedList() {
        top = null;
    }

    /**
     * Enter a data item at the front of the list.
     *
     * @param item item to add to the front of the list.
     */
    public void push(T item) {
        Node<T> ptr = new Node<>(); // Construct a new Node<T> - ptr points to it.
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
        Node<T> ptr = top; // A pointer to travel the list.
        int count = 0; // Counts the object of nodes.

        while (ptr != null) // While not at the end of the list.
        {
            count++; // Add this Node<T> to the count.
            ptr = ptr.next; // Move to the next node.
        }

        return count; // Return the object of nodes.
    }

    /**
     * Removes the first element.
     *
     * @return first element.
     */
    public T pop() {
        Node<T> temp = top;
        top = top.next;
        return temp.data;
    }

    /**
     * Gets the first Element
     *
     * @return the first element data
     */
    public T peek() {
        return top.data;
    }

    /**
     * Checks if list is empty.
     *
     * @return true if list is empty
     *         false if list is not
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Display the contents of the linked list.
     */
    public void display() {
        Node<T> ptr = top; // Pointer to traverse the list.

        while (ptr != null) { // While not at the end of the list ...
            T data = ptr.data; // Get data of current node.
            System.out.println(data); // PrT the data.
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
     * Node<T> Class.
     */
    private class Node<T> {
        public T data; // Data stored in the Node.
        public Node<T> next; // Pointer to next Node<T> in the list.
    }
}