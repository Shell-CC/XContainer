package container;

/**
 * Implements of FIFO queue.
 *
 */
public interface Queue<E> extends Iterable<E> {

    /**
     * Insert an item at the end of the queue.
     * @param item the element to be added
     */
    public abstract void offer(E item);


    /**
     * Remove and return the element at the begining of the queue.
     * @return the element removed
     */
    public abstract E poll();


    /**
     * Return the element at the begining of the queue without removing it.
     * @return the element retrived
     */
    public abstract E peek();


    /**
     * Check if the queue is empty.
     * @return true if it is empty, or else false
     */
    public abstract boolean isEmpty();


    /**
     * Return the number of elements in the queue.
     * @return the number of elements in the queue.
     */
    public abstract int size();
}

class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super();
    }
}