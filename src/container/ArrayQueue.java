package container;

/**
 * Resizable array implementation of Queue interface.
 *
 */

public class ArrayQueue<E> extends ResizableArray<E> implements Queue<E> {
    private int front;    // index of the first item
    private int rear;     // index of the last item

    /**
     * Construct a array queue with an initial capacity sufficient to hold 10 items
     */
    public ArrayQueue() {
        super();
        front = 0;
        rear = -1;
    }


    /**
     * Insert and item at the end of the queue
     * @param item The element to be inserted
     */
    public void offer(E item) {
        if (rear == arr.length - 1) {
            resizing(size*2);
        }
        arr[++rear] = item;
        size++;
    }


    /**
     * Retrives the item from the head of the queue without removing it.
     * @return The head of the queue.
     * @throws EmptyQueueException If the queue is empty.
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        try {
            return (E) arr[front];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyQueueException();
        }
    }

    /**
     * Retrives and removes the item at the head of the queue.
     * @return The head of the queue.
     * @throws EmptyQueueException If the queue is Empty.
     */
    @SuppressWarnings("unchecked")
    public E poll() {
        try {
            E item = (E) arr[front];
            arr[front++] = null;
            size--;
            if (size <= arr.length/4 && size > 10) {
                resizing(size*2);
            }
            return item;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyQueueException();
        }
    }
}