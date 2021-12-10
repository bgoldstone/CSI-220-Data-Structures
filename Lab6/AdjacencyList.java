import java.util.Arrays;

/**
 * Creates an object of an AdjacencyList for a Graph.
 *
 * @author Ben Goldstone
 * @version 11/30/2021
 */
public class AdjacencyList {

    private final int numberOfNodes;
    private final GraphNode[] graphNodes;

    /**
     * Constructor for a {@link AdjacencyList}.
     *
     * @param numberOfNodes number of Nodes in the AdjacencyList.
     */
    public AdjacencyList(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        graphNodes = new GraphNode[numberOfNodes];
    }

    /**
     * Inserts {@link GraphNode} into {@link AdjacencyList}.
     *
     * @param to     Where the Current Node points to.
     * @param from   The Current Node.
     * @param weight The weight of the edge between the Nodes.
     */
    public void insert(int from, int to, int weight) {
        GraphNode newNode = new GraphNode(to, weight);
        GraphNode current = graphNodes[from];
        if (current == null) {
            graphNodes[from] = newNode;
        } else if (current.next == null) {
            current.next = new GraphNode(to, weight);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new GraphNode(to, weight);
        }
    }

    /**
     * Displays the whole AdjacencyList.
     */
    public void display() {
        int currentNode = 0;
        for (GraphNode current : graphNodes) {
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
        int[] visited = new int[numberOfNodes];
        Stack stack = new Stack(numberOfNodes);
        stack.push(0);
        int current;
        GraphNode currentNode;
        int pos = 0;
        while (!stack.isEmpty()) {
            current = stack.pop();

            if (notInArray(current, pos, visited)) {
                currentNode = graphNodes[current];
                while (currentNode != null) {
                    stack.push(currentNode.to);
                    currentNode = currentNode.next;
                }
                visited[pos] = current;
                pos++;
            }
        }

        System.out.println("DFS: " + Arrays.toString(visited));
    }

    /**
     * Displays Breath First Search algorithm on AdjacencyList
     */
    public void displayBFS() {
        int[] visited = new int[numberOfNodes];
        Queue queue = new Queue(numberOfNodes);
        queue.enqueue(0);
        int current;
        GraphNode currentNode;
        int pos = 0;
        while (!queue.isEmpty()) {
            current = queue.dequeue();

            if (current >= 0 && notInArray(current, pos, visited)) {
                currentNode = graphNodes[current];
                while (currentNode != null) {
                    queue.enqueue(currentNode.to);
                    currentNode = currentNode.next;
                }
                visited[pos] = current;
                pos++;
            }
        }

        System.out.println("BFS: " + Arrays.toString(visited));
    }

    /**
     * Displays if value is in array.
     *
     * @param value value to search for.
     * @param pos   the max position to search to.
     * @param arr   the array of integers.
     * @return true if value in Array.
     */
    public boolean notInArray(int value, int pos, int[] arr) {
        for (int i = 0; i < pos; i++) {
            if (arr[i] == value)
                return false;
        }
        return true;
    }

    /**
     * Dijkstra's Algorithm from a node to another node.
     *
     * @param startNode The node number to start with.
     */
    public void findShortestPath(int startNode) {
        int[][] dijkstraArray = new int[numberOfNodes][3];
        MinHeap dijkstraHeap = new MinHeap(numberOfNodes);
        ShortestPathNode shortestPathNode;
        GraphNode graphNode;
        //init array
        for (int i = 0; i < dijkstraArray.length; i++) {
            //known
            dijkstraArray[i][0] = 0;
            //distance
            dijkstraArray[i][1] = Integer.MAX_VALUE;
            //previous
            dijkstraArray[i][2] = 0;
        }
        //sets first node pv to 0
        try {
            dijkstraArray[startNode][1] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Start Node!");
            return;
        }
        //inserts first node
        dijkstraHeap.insert(new ShortestPathNode(startNode, dijkstraArray[startNode][1]));

        while (!dijkstraHeap.isEmpty()) {
            shortestPathNode = dijkstraHeap.remove();
            graphNode = graphNodes[shortestPathNode.nodeNumber];
            while (graphNode != null) {
                if ((shortestPathNode.distanceFromStart + graphNode.weight < dijkstraArray[graphNode.to][1]) && (dijkstraArray[graphNode.to][0] == 0)) {
                    dijkstraArray[graphNode.to][1] = shortestPathNode.distanceFromStart + graphNode.weight;
                    //sets distance in array
                    dijkstraArray[graphNode.to][2] = shortestPathNode.nodeNumber;
                }
                graphNode = graphNode.next;
            }
            dijkstraArray[shortestPathNode.nodeNumber][0] = 1;
            //clears heap
            dijkstraHeap.clearHeap();
            for (int i = 0; i < dijkstraArray.length; i++) {
                if (dijkstraArray[i][0] == 0) {
                    dijkstraHeap.insert(new ShortestPathNode(i, dijkstraArray[i][1]));
                }
            }

        }
        System.out.println();
        for (int i = 0; i < dijkstraArray.length; i++) {
            System.out.println("Node Number: " + i + " distance from node " + startNode +
                    ": " + dijkstraArray[i][1] + " From Node: " + dijkstraArray[i][2]);
        }
    }

    /**
     * Creates an object of a GraphNode.
     */
    static class GraphNode {
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
