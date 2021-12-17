import java.util.Comparator;

/**
 * AVL Tree Data Structure with some help from geeksforgeeks.org.
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> {
    private Node root;

    /**
     * gets height at node n.
     *
     * @param n Node to get height of.
     * @return height.
     */
    private int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    /**
     * Gets max of two types
     *
     * @param a first element.
     * @param b second element.
     * @return biggest element.
     */
    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        //rotation
        x.right = y;
        y.left = T2;

        //update heights
        y.height = max(height(y.left), height(y.right) + 1);
        x.height = max(height(x.left), height(x.right) + 1);
        return x;
    }

    /**
     * Performs left rotation.
     *
     * @param x Node to rotate.
     * @return Node x.
     */
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        //rotation
        y.left = x;
        x.right = T2;

        //update heights
        y.height = max(height(y.left), height(y.right) + 1);
        x.height = max(height(x.left), height(x.right) + 1);

        return y;
    }

    /**
     * Gets balance of a node.
     *
     * @param n Node to get a balance of.
     * @return balance.
     */
    private int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.right) - height(n.left);
    }

    /**
     * Inserts a node.
     *
     * @param key value to insert.
     */
    public void insert(T key) {
        root = insert(root, key);
    }

    /**
     * private insert method.
     *
     * @param node usually root to start.
     * @param key  value to insert.
     * @return Node node.
     */
    private Node insert(Node node, T key) {
        if (node == null)
            return new Node(key);
        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key);
        else
            return node;
        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);
        //Left Left case
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        //Right Right case
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);
        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;

    }

    /**
     * Prints AVLTree inOrder.
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * Private method that prints AVLTree inOrder.
     *
     * @param node root node to start with.
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + " ");
            inOrder(node.right);
        }
    }

    /**
     * Gets minimum value of node.
     *
     * @param node Node to check.
     * @return Node
     */
    private Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    /**
     * Deletes node based on specified value.
     * @param key value to delete.
     * @return value deleted.
     */
    public T deleteNode(T key){
        deleteNode(root,key);
        return key;
    }

    /**
     * Deletes Node
     * @param root root Node.
     * @param key value to remove.
     * @return root Node.
     */

    private Node deleteNode(Node root, T key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return null;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key.compareTo(root.key) < 0)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key.compareTo(root.key) > 0)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return null;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    /**
     * Node object.
     */
    private class Node {
        private T key;
        private int height;
        private Node left, right;

        /**
         * Node Constructor.
         *
         * @param key value to insert.
         */
        private Node(T key) {
            this.key = key;
            height = 1;
        }
    }
}
