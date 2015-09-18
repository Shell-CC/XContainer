package container;

import java.util.Iterator;

/**
 * General Binary Search Tree implemetation.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements Iterable<E> {

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
        root = insert(root, item);
    }
    private Node<E> insert(Node<E> root, E item) {
        if (root == null) {
            return new Node<>(item);
        }
        if (item.compareTo(root.data) < 0) {
            root.left = insert(root.left, item);
        } else {
            root.right = insert(root.right, item);
        }
        return root;
    }


    /**
     * Return an iterator of all elements in ascendant order.
     * @return An ascendant order.
     */
    public Iterator<E> iterator() {
        return inorderIterator();
    }
}