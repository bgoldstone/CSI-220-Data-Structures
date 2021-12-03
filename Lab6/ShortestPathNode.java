/**
 * Node for ShortestPath MinHeap.
 */
public class ShortestPathNode {
    int nodeNumber;
    int distanceFromStart;

    /**
     * Shortest path node for start Node.
     *
     * @param nodeNumber        node number in the graph.
     * @param distanceFromStart usually 0, distance from start node to start node.
     */
    public ShortestPathNode(int nodeNumber, int distanceFromStart) {
        this.nodeNumber = nodeNumber;
        this.distanceFromStart = distanceFromStart;
    }
}
