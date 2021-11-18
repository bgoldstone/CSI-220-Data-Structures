/**
 * Creates an object of an OpenHashTable.
 */
public class OpenHashTable<T> {
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
    public void insert(T key, T value) {
        HashTableNode current = nodeArray[((int) key) % D];
        if (current != null) {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new HashTableNode(key, value);
        } else {
            current = new HashTableNode(key, value);
        }
    }

    /**
     * Finds ot key exists in the OpenHashTable.
     *
     * @param key key to find in OpenHashTable.
     * @return true if item is in the OpenHashTable.
     */
    public T search(T key) {
        HashTableNode current = nodeArray[((int) key) % D];
        if (current != null) {
            while (current.next != null) {
                if (current.key.equals(key))
                    return (T) current.value;
                else {
                    current = current.next;
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
    public boolean remove(T key) {
        HashTableNode current = nodeArray[((int) key) % D];
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
    class HashTableNode<T> {
        T key;
        T value;
        HashTableNode next;

        /**
         * Constructor for a HashTableNode.
         *
         * @param key   key to use in HashTableNode.
         * @param value value to use in HashTableNode.
         */
        public HashTableNode(T key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
