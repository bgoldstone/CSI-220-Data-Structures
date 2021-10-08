/**
 * A DoublyLinkedList that is sorted
 *
 * @param <T> DataType of LinkedList.
 */
public class SortedDoubleList<T extends Comparable<T>> {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    /**
     * Primary SortedDoubleList Constructor
     */
    public SortedDoubleList() {
        head = new DoubleNode(0);
        tail = new DoubleNode(0);
        size = 0;
        head.next = tail;
        head.previous = null;
        tail.next = null;
        tail.previous = head;

    }

    /**
     * Checks if list is empty.
     *
     * @return true if empty.
     */
    public boolean empty() {
        return head.next == tail;
    }

    /**
     * Gets size of list.
     *
     * @return number of data nodes in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Gets first item.
     *
     * @return first item.
     */
    public T front() {
        if (head.next != tail)
            return (T) head.next.value();
        else {
            return null;
        }
    }

    /**
     * Gets last item.
     *
     * @return last item.
     */
    public T back() {
        if (tail.previous != head)
            return (T) tail.previous.value();
        else {
            return null;
        }
    }

    /**
     * Returns number of occurrences of an object.
     *
     * @param obj value to count.
     * @return number of given item in the List.
     */
    public int count(T obj) {
        int count = 0;
        DoubleNode current = head.next;
        // goes through list
        while (current != null) {
            // if item matches
            if (current.value().equals(obj))
                count++;
            // increments the list
            current = current.next;
        }
        return count;
    }

    /**
     * Inserts items in a sorted order.
     *
     * @param obj value to insert.
     */
    public void insert(T obj) {
        DoubleNode newNode = new DoubleNode(obj);
        // if empty list
        if (empty()) {
            newNode.next = tail;
            newNode.previous = head;
            head.next = newNode;
            tail.previous = newNode;
            // if item is smaller than first item
        } else if (head.next.value().compareTo(obj) > 0) {
            newNode.next = head.next;
            newNode.previous = head;
            head.next = newNode;
            newNode.next.previous = newNode;
        } else {

            DoubleNode current = head.next;
            // while not tail or null
            while (current.next != tail) {
                // if value is smaller or equal
                if ((current.next.value().compareTo(obj) > 0))
                    break;
                // increment Node
                current = current.next;
            }
            // if last element
            if (current.next == tail) {
                newNode.next = tail;
                newNode.previous = current;
                current.next = newNode;
                tail.previous = newNode;
            } else {
                newNode.next = current.next;
                newNode.previous = current;
                current.next = newNode;
                newNode.next.previous = newNode;

            }
        }
        size++;
    }

    /**
     * Removes the first item in the List.
     *
     * @return first item in the list.
     */
    public T pop_front() {
        // if empty
        if (empty())
            return null;
        T val = (T) head.next.value();
        head.next.next.previous = head;
        head.next = head.next.next;
        size--;
        return val;
    }

    /**
     * Removes the last item in the List.
     *
     * @return last item in the list.
     */
    public T pop_back() {
        // if empty
        if (empty())
            return null;
        // get last value
        T val = (T) tail.previous.value();
        // disconnect node from the list
        tail.previous.previous.next = tail;
        tail.previous = tail.previous.previous;
        size--;
        return val;
    }

    /**
     * Removes the first occurence of the given value.
     *
     * @param obj value to remove.
     * @return number of nodes removed.
     */
    public int erase(T obj) {
        DoubleNode current = head;
        int val = 0;
        // increments through the list
        while (current.next != null) {
            // if value remove it
            if (current.value().equals(obj)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
                val++;
            }
            // increments node
            current = current.next;
        }
        return val;
    }

    /**
     * Returns the List in an east to read array format.
     *
     * @return List.
     */
    public String toString() {
        // if empty
        if (empty()) {
            return "[]";
        } else {
            DoubleNode current = head.next;
            StringBuilder sb = new StringBuilder("[");
            while (current.next != tail && current.next != null) {
                sb.append(current.value() + ", ");
                current = current.next;
            }
            sb.append(current.value());
            sb.append("]");
            return sb.toString();
        }
    }

    /**
     * DoubleNode class.
     *
     * @param <T> Data type of Node.
     */
    class DoubleNode<T extends Comparable<T>> {
        DoubleNode next;
        DoubleNode previous;
        T node_value;

        /**
         * Initializes node with a value.
         *
         * @param obj A value (must be same data type as {@link SortedDoubleList}
         *            class).
         */
        public DoubleNode(T obj) {
            node_value = obj;
            next = null;
            previous = null;
        }

        /**
         * Gets value of the node.
         *
         * @return value of the node.
         */
        public T value() {
            return node_value;
        }

    }

}
