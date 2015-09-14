package container;

import java.util.Iterator;

/**
 * A sinlge linked list.
 */
public abstract class AbstractLinkedList<E> implements Iterable<E>{
    protected LinkedNode<E> head;
    protected int size;


    /**
     * Sole constructor
     */
    public AbstractLinkedList() {
        head = null;
        size = 0;
    }


    /**
     * Return the number of items in the linked list.
     * @return number of items.
     */
    public int size() {
        return size;
    }


    /**
     * Check if the list is empty
     * @return true if it is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Return an iterator of the list
     * @return iterator in specific order
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedNode<E> curr = head;
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E item = curr.item;
                curr = curr.next;
                return item;
            }
            public void remove() {}
        };
    }
}

class LinkedNode<E> {
    E item;
    LinkedNode<E> next;

    public LinkedNode(E item, LinkedNode<E> next) {
        this.item = item;
        this.next = next;
    }

    public LinkedNode(E item) {
        this(item, null);
    }

    public LinkedNode() {
        this(null, null);
    }
}