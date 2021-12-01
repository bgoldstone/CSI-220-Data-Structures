import java.util.Arrays;

/**
 * Creates an object of an AdjacencyList for a Graph.
 * @author Ben Goldstone
 * @version 11/30/2021
 */
public class AdjacencyList {

    private final int numOfNodes;
    private final GraphNode[] nodeArray;

    /**
     * Constructor for a {@link AdjacencyList}.
     *
     * @param numOfNodes number of Nodes in the AdjacencyList.
     */
    public AdjacencyList(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        nodeArray = new GraphNode[numOfNodes];
    }

    /**
     * Inserts {@link GraphNode} into {@link AdjacencyList}.
     *
     * @param to     Where the Current Node points to.
     * @param from   The Current Node.
     * @param weight The weight of the edge between the Nodes.
     */
    public void insert(int to, int from, int weight) {
        GraphNode newNode = new GraphNode(to, weight);
        GraphNode current = nodeArray[from];
        if (current == null) {
            nodeArray[from] = newNode;
        } else if (current.next == null) {
            current.next = new GraphNode(to, weight);
        } else {
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = new GraphNode(to, weight);
        }
    }

//    /**
//     * Finds ot key exists in the OpenHashTable.
//     *
//     * @param key key to find in OpenHashTable.
//     * @return true if item is in the OpenHashTable.
//     */
//    public String search(int from) {
//        GraphNode current = nodeArray[from];
//        if (current != null) {
//            while (current != null) {
//                if (current.key.equals(key))
//                    return current.value;
//                else {
//                    current = current.next;
//                }
//            }
//        }
//        return null;
//    }

    /**
     * Displays the whole AdjacencyList.
     */
    public void display() {
        int currentNode = 0;
        for (GraphNode current : nodeArray) {
            System.out.println("Node " + currentNode + ":");
            if (current != null) {
                while (current != null) {
                    System.out.println("\tTo : " + current.to + " Weight: " + current.weight + ", ");
                    current = current.next;
                }
                System.out.println();
            }
            currentNode++;
        }
    }

    /**
     * Displays Depth First Search Algorithm on AdjacencyList
     */
    public void displayDFS() {
        int[] visited = new int[numOfNodes];
        Stack<Integer> stack = new Stack<>(numOfNodes);
        stack.push(0);
        int current;
        GraphNode currentNode;
        boolean firstTime = true;
        int pos = 0;
        while (pos != visited.length - 1 || firstTime) {
            current = stack.pop();
            if (Arrays.binarySearch(visited, current) < 0) {
                currentNode = nodeArray[current];
                visited[++pos] = current;
                while (currentNode != null) {
                    stack.push(currentNode.to);
                    currentNode = currentNode.next;
                }
            }
            firstTime = false;
        }
        System.out.println(Arrays.toString(visited));
    }

    /**
     * Displays Breath First Search algorithm on AdjacencyList
     */
    public void displayBFS() {
        int[] visited = new int[numOfNodes];
        Queue queue = new Queue(numOfNodes);
        queue.enqueue(0);
        int current;
        GraphNode currentNode;
        boolean firstTime = true;
        int pos = 0;
        while (pos != visited.length - 1 || firstTime) {
            current = queue.dequeue();
            if (Arrays.binarySearch(visited, current) < 0) {
                currentNode = nodeArray[current];
                visited[++pos] = current;
                while (currentNode != null) {
                    queue.enqueue(currentNode.to);
                    currentNode = currentNode.next;
                }
            }
            firstTime = false;
        }
        System.out.println(Arrays.toString(visited));

    }

    /**
     * Dijkstra's Algorithm from a node to another node.
     * @param startNode The node number to start with.
     * @param endNode The node number to end with.
     * @return String with the shortest Path.
     */
    public String findShortestPath(int startNode, int endNode){
        StringBuilder sb = new StringBuilder("The shortest path from ");
        sb.append(startNode);
        sb.append(" to ");
        sb.append(endNode);
        sb.append(" is: ");
        return sb.toString();
    }

//    /**
//     * Removes the given HashNode from the OpenHashTable.
//     *
//     * @param key key to remove from the OpenHashTable.
//     */
//    public boolean remove(String key) {
//        int asciiValue = getAsciiValue(key) % numOfNodes;
//        GraphNode current = nodeArray[asciiValue];
//        if (current == null) {
//            return false;
//        }
//        //if first node
//        if (current.key.equals(key)) {
//            nodeArray[asciiValue] = current.next;
//            return true;
//        }
//
//        while (current.next != null) {
//            if (current.next.key.equals(key)) {
//                if (current.next.next != null)
//                    current.next = current.next.next;
//                else
//                    current.next = null;
//                return true;
//            } else if (current.next == null) {
//                current = null;
//
//            } else
//                current = current.next;
//        }
//
//
//        return false;
//    }

    /**
     * Creates an object of a GraphNode.
     */
    class GraphNode {
        int to;
        int weight;
        GraphNode next;

        /**
         * Constructor for a GraphNode.
         *
         * @param to     Node that the current Node points to.
         * @param weight Weight of from current Node to other Node.
         */
        public GraphNode(int to, int weight) {
            this.to = to;
            this.weight = weight;
            this.next = null;
        }
    }

}
