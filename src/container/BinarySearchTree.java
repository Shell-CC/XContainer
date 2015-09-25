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
     * @return this binary search tree.
     */
    public BinarySearchTree<E> insert(E item) {
        this.root = insert(this.root, item);
        return this;
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


    /**
     * Get kth smallest element in the BST. k should be 0 &lt;= k &lt; size().
     * @param k The index of elements to retrive.
     * @return kth smallest element.
     * @throws IllegalArgumentException If k &lt; 0, k &gt; size().
     */
    public E get(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("k should be no smaller than 0");
        }
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            E item = it.next();
            if (k-- == 0) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }


    /**
     * Build a balanced BST from a sorted array.
     * @param sorted The given sorted array in ascending order.
     */
    public void build(Comparable[] sorted) {
        root = build(sorted, 0, sorted.length - 1);
    }
    private Node<E> build(Comparable[] sorted, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            return null;
        }
        int midIndex = fromIndex + (toIndex - fromIndex)/2;
        @SuppressWarnings("unchecked")
        Node<E> root = new Node<>((E) sorted[midIndex]);
        root.left = build(sorted, fromIndex, midIndex-1);
        root.right = build(sorted, midIndex+1, toIndex);
        return root;
    }
}