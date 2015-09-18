package container;

/**
 * General Binary Search Tree implemetation.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Search a specific element in the BST.
     * @return The node if found, or null;
     */
    private Node<E> search(E item) {
        return search(this.root, item);
    }
    private Node<E> search(Node<E> root, E item) {
        if (root == null || root.data == item) {
            return root;
        } else if (item.compareTo(root.data) < 0) {
            return search(root.left, item);
        } else {
            return search(root.right, item);
        }
    }

    /**
     * Insert a specific element into the BST.
     * @param item The element to insert.
     */
    public void insert(E item) {
        insert(this.root, item);
    }
    private void insert(Node<E> root, E item) {
        if (root == null) {
            root = new Node<E>(item);
        }
        if (item.compareTo(root.data) < 0) {
            insert(root.left, item);
        } else {
            insert(root.right, item);
        }
    }
}