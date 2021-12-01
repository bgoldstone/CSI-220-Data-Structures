/**
 * Node for ShortestPath MinHeap.
 */
public class ShortestPathNode {
    int nodeNumber;
    boolean known;
    int distanceFromStart;
    int previousNode;

    /**
     * Regular shortest path node.
     * @param nodeNumber node number in the graph.
     */
    public ShortestPathNode(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        this.known = false;
        this.distanceFromStart = Integer.MAX_VALUE;
        this.previousNode = -1;
    }

    /**
     * Shortest path node for start Node.
     * @param nodeNumber node number in the graph.
     * @param distanceFromStart usually 0, distance from start node to start node.
     */
    public ShortestPathNode(int nodeNumber, int distanceFromStart) {
        this.nodeNumber = nodeNumber;
        this.known = false;
        this.distanceFromStart = distanceFromStart;
        this.previousNode = -1;
    }
}
