public class SortedDoubleList<T extends Comparable<T>> {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public SortedDoubleList() {
        head = new DoubleNode(0);
        tail = new DoubleNode(0);
        int count = 2;
        size = 0;
        head.next = tail;
        head.previous = null;
        tail.next = null;
        tail.previous = head;

    }

    public boolean empty() {
        return head.next == tail;
    }

    public int size() {
        return size;
    }

    public T front() {
        return (T) head.next.value();
    }

    public T back() {
        return (T) tail.previous.value();
    }

    public int count(T obj) {
        int count = 0;
        DoubleNode position = head.next;
        while (position != null) {
            if (position.value().equals(obj))
                count++;
            position = position.next;
        }
        return count;
    }

    public void insert(T obj) {
        DoubleNode newNode = new DoubleNode(obj);
        //if empty list
        if (empty()) {
            //head <--> newNode <--> Tail
            newNode.next = tail;
            newNode.previous = head;
            head.next = newNode;
            tail.previous = newNode;
            //if item is smaller than first item
        } else if (head.next.value().compareTo(obj) > 0) {
            //sets next and previous
            newNode.next = head.next;
            newNode.previous = head;
            head.next = newNode;
            newNode.next.previous = newNode;

        } else {

            DoubleNode current = head.next;
            //while not tail or null
            while (current.next != tail) {
                //if value is smaller or equal
                if ((current.next.value().compareTo(obj) > 0))
                    break;
                //increment Node
                current = current.next;
            }
            //if last element
            if (current.next == tail) {
                newNode.next = tail;
                newNode.previous = current;
                current.next = newNode;
                tail.previous = newNode;
            } else {
                //current <--> newNode <--> newNode.next
                newNode.next = current.next;
                newNode.previous = current;
                current.next = newNode;
                if (current.next != null)
                    newNode.next.previous = newNode;

            }
        }
        size++;
    }

    public T pop_front() {
        if (head.next == tail)
            return null;
        T val = (T) head.next.value();
        head.next.next.previous = head;
        head.next = head.next.next;
        size--;
        return val;
    }

    public T pop_back() {
        if (head.next == tail)
            return null;
        T val = (T) tail.previous.value();
        tail.previous.previous.next = tail;
        tail.previous = tail.previous.previous;
        size--;
        return val;
    }

    public int erase(T obj) {
        DoubleNode current = head;
        int val = 0;
        while (current.next != null) {
            if (current.value().equals(obj)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
                val++;
                break;
            }
            current = current.next;
        }
        return val;
    }

    public String toString() {
        if(empty()){
            return "[]";
        }else{
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

    class DoubleNode<T extends Comparable<T>> {
        DoubleNode next;
        DoubleNode previous;
        T node_value;

        public DoubleNode(T obj) {
            node_value = obj;
            next = null;
            previous = null;
        }

        public T value() {
            return node_value;
        }

    }

}
