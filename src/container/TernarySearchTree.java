package container;

public class TernarySearchTree<V> {
    private Node root;
    private int size;

    /**
     * Construct an empty ternary search tree.
     *
     */
    public TernarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Put a key(String)-value pair into the table.
     * If the key is already existed, replace it with new value.
     * @param key The string with with the specific value is associated.
     * @param value The speicific value associated with the string.
     */
    public void put(String key, V value) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("Key is empty or null");
        }
        root = put(root, key, value, 0);
    }
    /**
     * Change the value associated with key if in subtrie rooted with n
     */
    private Node put(Node n, String key, V value, int keyIndex) {
        char c = key.charAt(keyIndex);
        if (n == null) {
            n = new Node(c);
        }
        if (keyIndex < key.length() - 1) { // if not finish, insert in the subtree
            if (c < n.key) {
                n.left = put(n.left, key, value, keyIndex+1);
            } else if (c > n.key) {
                n.right = put(n.right, key, value, keyIndex+1);
            } else {
                n.middle = put(n.middle, key, value, keyIndex+1);
            }
        } else { // if reach the end of string, set the value.
            n.value = value;
            size++;
        }
        return n;
    }


    /**
     * Retrive the value to which the key(string) is mapped.
     * @param key The specific string whose associated value is to be returned
     * @return The value associated if it is exist, or else null.
     */
    public V get(String key) {
        Node n = get(root, key, 0);
        return n == null ? null : n.value;
    }
    /**
     * Return the value associated with the key in the subtrie rooted with n.
     */
    private Node get(Node n, String key, int keyIndex) {
        // if not found
        if (n == null) {
            return null;
        }
        char c = key.charAt(keyIndex);
        if (c == n.key) { // if found
            return keyIndex == key.length() - 1 ? n : get(n.middle, key, keyIndex+1);
        } else {       // if not, search the subtrie
            return c < n.key ? get(n.left, key, keyIndex) : get(n.right, key, keyIndex);
        }
    }


    /**
     * Check if the table contains the specific key.
     * @param key The specific key to check.
     * @return true if the key is in the table.
     */
    public boolean contains(String key) {
        Node n = get(root, key, 0);
        return n == null ? true : false;
    }


    /**
     * Remove the key-value pair for a specific key from the table.
     * Not implemented yet!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @param key The specific key to be removed.
     * @return The value to which the specific value is mapped, null if key not found.
     */
    public V remove(String key) {
        Node n = get(root, key, 0);
        return n.value;
    }


    /**
     * Return the number of key-value pairs in the table.
     * @return The number of key-value pairs.
     */
    public int size() {
        return size;
    }

    private class Node {
        private V value;
        private char key;
        private Node left, middle, right;

        public Node(char key) {
            this.key = key;
        }
    }
}