/**
 * Creates an object of an OpenHashTable.
 */
public class OpenHashTable {
    private final int D;
    private final HashTableNode[] nodeArray;

    /**
     * Constructor for an Open Hash Table.
     *
     * @param D number of slots in the array. The bigger the D, the faster to find the key.
     */
    public OpenHashTable(int D) {
        this.D = D;
        nodeArray = new HashTableNode[D];
    }

    /**
     * Inserts HashTableNode into OpenHashTable.
     *
     * @param key   The key of the HashTableNode to insert.
     * @param value The value of the HashTableNode to insert.
     */
    public void insert(String key, String value) {
        HashTableNode row = nodeArray[(Integer.parseInt(key)) % D];
        if (row == null) {
            row = new HashTableNode(key, value);
        } else {
            while (row.next != null) {
                row = row.next;
            }
            row.next = new HashTableNode(key, value);

        }
    }

    /**
     * Finds ot key exists in the OpenHashTable.
     *
     * @param key key to find in OpenHashTable.
     * @return true if item is in the OpenHashTable.
     */
    public String search(String key) {
        HashTableNode row = nodeArray[Integer.parseInt(key) % D];
        if (row != null) {
            while (row.next != null) {
                if (row.key.equals(key))
                    return row.value;
                else {
                    row = row.next;
                }
            }
        }
        return null;
    }

    /**
     * Displays the whole OpenHashTable.
     */
    public void display() {
        int currentD = 0;
        for (HashTableNode current : nodeArray) {
            System.out.println("Row " + currentD + ":");
            if (current != null) {
                while (current != null) {
                    System.out.println("Key : " + current.key + " Value: " + current.value);
                    current = current.next;
                }
            }
            currentD++;
        }
    }

    /**
     * Removes the given HashNode from the OpenHashTable.
     *
     * @param key key to remove from the OpenHashTable.
     */
    public boolean remove(String key) {
        HashTableNode current = nodeArray[Integer.parseInt(key) % D];
        while (current != null) {
            if (current.next.value.equals(key)) {

                return true;
            }
            current.next = current.next.next;
        }
        return false;
    }

    /**
     * Creates an object of a HashTableNode.
     */
    class HashTableNode {
        String key;
        String value;
        HashTableNode next;

        /**
         * Constructor for a HashTableNode.
         *
         * @param key   key to use in HashTableNode.
         * @param value value to use in HashTableNode.
         */
        public HashTableNode(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
