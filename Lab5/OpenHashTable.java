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
        HashTableNode newNode = new HashTableNode(key, value);
        HashTableNode current = nodeArray[getAsciiValue(key) % D];
        if(search(key) != null){
            System.out.println("Key already exists!");
        }
        if (current == null) {
            nodeArray[getAsciiValue(key) % D] = newNode;
        } else if(current.next == null) {
            current.next = new HashTableNode(key,value);
        }else{
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = new HashTableNode(key, value);
        }
    }

    public int getAsciiValue(String key) {
        int returnValue = 0;
        for (char c : key.toCharArray()) {
            returnValue += c;
        }
        return returnValue;
    }

    /**
     * Finds ot key exists in the OpenHashTable.
     *
     * @param key key to find in OpenHashTable.
     * @return true if item is in the OpenHashTable.
     */
    public String search(String key) {
        HashTableNode current = nodeArray[getAsciiValue(key) % D];
        if (current != null) {
            while (current != null) {
                System.out.println(key);
                System.out.println(current.key);
                if (current.key.equals(key))
                    return current.value;
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
                    System.out.print("\tKey : " + current.key + " Value: " + current.value + ", ");
                    current = current.next;
                }
                System.out.println();
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
        int asciiValue = getAsciiValue(key) % D;
        HashTableNode current = nodeArray[asciiValue];
        if(current == null){
            return false;
        }
        //if first node
        if (current.value.equals(key)) {
            nodeArray[asciiValue] = current.next;
            return true;
        }

        while (current.next != null) {
            if (current.next.value.equals(key)) {
                if (current.next.next != null)
                    current.next = current.next.next;
                else
                    current.next = null;
                return true;
            }
            if (current.next != null)
                current.next = null;
            current = current.next;
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
