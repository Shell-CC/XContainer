package container;

public class Trie<V> implements Table<String, V>{

    private static final int R = 256;
    private Node root;

    /**
     * Put a key(String)-value pair into the table.
     * If the key is already existed, replace it with new value.
     * @param key The string with with the specific value is associated.
     * @param value The speicific value associated with the string.
     */
    public void put(String key, V value) {
        root = put(root, key, value, 0);
    }
    /**
     * Change the value associated with key if in subtrie rooted with n
     */
    private Node put(Node n, String key, V value, int d) {
        if (n == null) {
            n = new Node();
        }
        if (d == key.length()) {
            n.value = value;
            return n;
        }
        char c = key.charAt(d);
        n.next[c] = put(n.next[c], key, value, d+1);
        return n;
    }


    /**
     * Retrive the value to which the key(string) is mapped.
     * @param key The specific string whose associated value is to be returned
     * @return The value associated if it is exist, or else null.
     */
    @SuppressWarnings("unchecked")
    public V get(String key) {
        Node n = get(root, key, 0);
        return n == null ? null : (V) n.value;
    }
    /**
     * Return the value associated with the key in the subtrie rooted with n.
     */
    private Node get(Node n, String key, int d) {
        if (n == null) {
            return null;
        }
        return d == key.length() ? n : get(n.next[key.charAt(d)], key, d+1);
    }


    /**
     * Check if the table contains the specific key.
     * @param key The specific key to check.
     * @return true if the key is in the table.
     */
    public boolean contains(String key) {
        Node n = root;
        if (n == null) return false;
        for (int d = 0; d < key.length(); d++) {
            n = n.next[key.charAt(d)];
            if (n == null) return false;
        }
        return n.value != null;
    }


    /**
     * Remove the key-value pair for a specific key from the table.
     * Not implemented yet!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @param key The specific key to be removed.
     * @return The value to which the specific value is mapped, null if key not found.
     */
    public V remove(String key) {
        if (root == null) return null;
        Stack<Node> stack = new ArrayStack<>();
        // Search the key, if not in the trie, not modified
        Node n = root;
        for (int i = 0, N = key.length(); i < N; i++) {
            n = n.next[key.charAt(i)];
            if (n == null) {
                return null;
            } else {
                stack.push(n);
            }
        }
        // if found, unmark it.
        V val = (V) n.value;
        n.value = null;
        // delete the node until it is no longer prefix of others
        while (!stack.isEmpty()) {
            n = stack.pop();
            if (n.hasNoChildren() &&  n.value == null) {
                n = null;
            } else {
                return val;
            }
        }
        return val;
    }


    /**
     * Check if the table is empty.
     * @return true if it is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return the number of key-value pairs in the table.
     * @return The number of key-value pairs.
     */
    public int size() {
        return size(root);
    }
    private int size(Node n) {
        if (n == null) return 0;
        int size = 0;
        if (n.value != null) {
            size++;
        }
        for (char c = 0; c < R; c++) {
            size += size(n.next[c]);
        }
        return size;
    }

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
        // public Node() {
            // next = new Node[R];
        // }
        private boolean hasNoChildren() {
            for (Node i : next) {
                if (i != null) return false;
            }
            return true;
        }
    }
}