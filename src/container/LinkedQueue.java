package container;

/**
 * Linked list implementation of Queue interface.
 */
public class LinkedQueue<E> extends AbstractLinkedList<E> implements Queue<E>{
    private LinkedNode tail;

    /**
     * Constrruct an empty queue
     */
    public LinkedQueue() {
        super();
        tail = null;
    }


    /**
     * Insert an item at the end of the queue.
     * @param item the element to be added
     */
    public void offer(E item) {
        if (size == 0) {
            head = new LinkedNode(item);
            tail = head;
        } else {
            tail.next = new LinkedNode(item);
            tail = tail.next;
        }
        size++;
    }


    /**
     * Remove and return the element at the begining of the queue.
     * @return the element removed
     */
    public E poll() {
        try {
            E item = head.item;
            head = head.next;
            if (--size == 0) {
                tail = null;
            }
            return item;
        } catch (NullPointerException e) {
            throw new EmptyQueueException();
        }
    }


    /**
     * Return the element at the begining of the queue without removing it.
     * @return the element retrived
     */
    public E peek() {
        try {
            return head.item;
        } catch (NullPointerException e) {
            throw new EmptyQueueException();
        }
    }
}