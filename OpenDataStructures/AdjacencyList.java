import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
    private final int n;
    List[] adjacencyList;

    public AdjacencyList(int n) {
        this.n = n;
        adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new DoublyLinkedList<>() {
            };
        }
    }

    public void addEdge(int from, int to, int weight) {
        if (from >= n)
            throw new IndexOutOfBoundsException();
        adjacencyList[from].add(to, new Node(to, weight));
    }

    public void addEdge(int from, int to) {
        if (from >= n)
            throw new IndexOutOfBoundsException();
        adjacencyList[from].add(to, new Node(to, 0));

    }

    public void removeEdge(int from, int to) {
        DoublyLinkedList.Node fromValue = (DoublyLinkedList.Node) adjacencyList[from];
        while (fromValue != null) {
            if (((Node) fromValue.element).to == to) {
                adjacencyList[from].remove(fromValue.element);
                break;
            }
            fromValue = fromValue.next;
        }
    }

    public void removeEdge(int from, int to, int weight) {
        DoublyLinkedList.Node fromValue = (DoublyLinkedList.Node) adjacencyList[from];
        while (fromValue != null) {
            if ((((Node) fromValue.element).to == to) && (((Node) fromValue.element).weight == weight)) {
                adjacencyList[from].remove(fromValue.element);
                break;
            }
            fromValue = fromValue.next;
        }
    }

    public boolean hasEdge(int from, int to, int weight) {
        DoublyLinkedList.Node fromValue = (DoublyLinkedList.Node) adjacencyList[from];
        while (fromValue != null) {
            if ((((Node) fromValue.element).to == to) && (((Node) fromValue.element).weight == weight)) {
                adjacencyList[from].remove(fromValue.element);
                return true;
            }
            fromValue = fromValue.next;
        }
        return false;
    }

    public boolean hasEdge(int from, int to) {
        DoublyLinkedList.Node fromValue = (DoublyLinkedList.Node) adjacencyList[from];
        while (fromValue != null) {
            if (((Node) fromValue.element).to == to) {
                adjacencyList[from].remove(fromValue.element);
                return true;
            }
            fromValue = fromValue.next;
        }
        return false;
    }

    public List<Node> outEdges(int from) {
        DoublyLinkedList.Node fromValue = (DoublyLinkedList.Node) adjacencyList[from];
        List<Node> temp = new LinkedList<>();
        while (fromValue != null) {
            temp.add(((Node) fromValue.element));

            fromValue = fromValue.next;
        }
        return temp;
    }

    public List<Node> inEdges(int to) {
        List<Node> temp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            DoublyLinkedList.Node current = (DoublyLinkedList.Node) adjacencyList[i];
            while (current != null) {
                if (((Node) current.element).to == to)
                    temp.add((Node) current.element);
                current = current.next;
            }
        }
        return temp;
    }

    public class Node {
        public int to;
        public int weight;

        private Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
