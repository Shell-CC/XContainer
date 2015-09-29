package container;

/**
 * Implement a table using a red-black tree.
 *
 */
public class TreeTable<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;


    /**
     * Put a key-value pair into the table.
     * If the key is already existed, replace it with new value.
     * @param key The key with with the specific value is associated.
     * @param value The speicific value associated with the key.
     * //@return The previous value assicated with the key if existed, or else null.
     */
    public void put(K key, V value) {
        root = insert(root, key, value);
        root.color = BLACK;
    }
    private Node insert(Node root, K key, V value) {
        if (root == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            root.val = value;
        } else if (cmp < 0) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }
        if (!isRed(root.left) && isRed(root.right)) {
            rotateLeft(root);
        }
        if (isRed(root.left) && isRed(root.left.left)) {
            rotateRight(root);
        }
        if (isRed(root.left) && isRed(root.right)) {
            split(root);
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    private int size(Node n) {
        return n == null ? 0 : n.size;
    }

    private Node rotateLeft(Node l) {
        Node r = l.right;
        l.right = r.left;
        r.left = l;
        r.color = l.color;
        l.color = RED;
        r.size = l.size;
        l.size = 1 + size(l.left) + size(l.right);
        return r;
    }

    private Node rotateRight(Node r) {
        Node l = r.left;
        r.left = l.right;
        l.right = r;
        l.color = r.color;
        r.color = RED;
        l.size = r.size;
        r.size = 1 + size(r.left) + size(r.right);
        return l;
    }

    private boolean isRed(Node n) {
        if (n == null) return false;
        return n.color == RED;
    }

    private void split(Node n) {
        n.color = RED;
        n.left.color = BLACK;
        n.right.color = BLACK;
    }

    private class Node {
        K key;
        V val;
        int size;
        boolean color;
        Node left, right;

        Node(K key, V val, int size, boolean color) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }
    }
}