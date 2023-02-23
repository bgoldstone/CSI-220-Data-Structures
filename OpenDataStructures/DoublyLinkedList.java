import java.io.Serializable;
import java.util.*;
import java.util.Queue;


/**
 * A Singly Linked List with a tail based on opendatastructures.org
 */
public class DoublyLinkedList<E> extends AbstractList<E> implements List<E>, Collection<E>, Iterable<E>, Serializable, Queue<E>, MyStack<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * {@link DoublyLinkedList} constructor method.
     */
    public DoublyLinkedList() {
        size = 0;
    }

    /**
     * Gets element at specified index.
     *
     * @param index index to retrieve element.
     * @return Element at position of index.
     */
    @Override
    public E get(int index) {
        Node current = head;
        if (index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        return current.element;
    }

    /**
     * Gets current size of list.
     *
     * @return size.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element value to insert in list.
     * @return true if element added.
     */
    @Override
    public boolean add(E element) {
        Node newNode = new Node(element);
        if (empty()) {
            head = newNode;
        } else if (size == 1) {
            head.next = newNode;
            newNode.prev = head;

        } else {
            tail.prev = newNode;
            newNode.prev = tail.prev;
        }
        tail = newNode;
        size++;
        return true;
    }

    /**
     * Adds value at given index.
     *
     * @param index   index to insert element at.
     * @param element value to insert.
     */
    public void add(int index, E element) {
        if (index >= size) {
            add(element);
            return;
        }
        if (index < 0)
            throw new IndexOutOfBoundsException();
        if (element == null) {
            throw new NullPointerException();
        } else {
            Node current = head;
            Node newNode = new Node(element);
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev = newNode;
            newNode.prev.next = newNode;
        }
    }

    /**
     * Inserts element at the end of the list. used for {@link Queue} interface,
     *
     * @param element element to insert.
     * @return true if element added.
     */
    @Override
    public boolean offer(E element) {
        add(element);
        return true;

    }

    @Override
    public E remove() {
        if (empty())
            throw new NoSuchElementException();
        else {
            Node removed = head;
            head = head.next;
            size--;
            return removed.element;
        }
    }

    public E remove(int index) {
        Node current = head;
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;
        return current.element;
    }


    public int indexOf(Object o) {
        Node current = head;
        for (int i = 0; i < size + 1; i++) {
            if (current.element.equals(o))
                return i;
            current = current.next;
        }
        return -1;

    }

    public int lastIndexOf(Object o) {
        Node current = tail;
        for (int i = 0; i < size + 1; i++) {
            if (current.element.equals(o))
                return i;
            current = current.prev;
        }
        return -1;

    }

    @Override
    public E poll() {
        if (empty())
            return null;
        else {
            Node removed = head;
            head = head.next;
            size--;
            return removed.element;
        }
    }

    @Override
    public E element() {
        if (empty())
            throw new NoSuchElementException();
        else
            return head.element;

    }

    @Override
    public E peek() {
        if (empty())
            return null;
        return head.element;
    }

    @Override
    public E pop() {
        if (empty()) {
            return null;
        } else {
            Node returnValue = head;
            head = head.next;
            return returnValue.element;
        }
    }

    @Override
    public E push(E item) {
        Node newNode = new Node(item);
        if (!empty()) {
            newNode.next = head;
        }
        head = newNode;
        return newNode.element;
    }

    @Override
    public int search(Object o) {
        return indexOf(o);
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append("Node #");
            sb.append(i);
            sb.append(" Value: ");
            sb.append(current.element);
            if (i != size - 1) {
                sb.append(",");
                sb.append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }



    class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element) {
            this.element = element;
        }
    }
}