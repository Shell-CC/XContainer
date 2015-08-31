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
        if (arr.length == size) {
            resizing(2*size);
        }
        arr[++rear] = item;
        size++;
    }


    /**
     * Retrives the item from the head of the queue without removing it.
     * @return The head of the queue.
     * @throws EmptyQueueException If the queue is empty.
     */
    public E peek() {
        try {
            return arr[front];
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
    public E poll() {
        try {
            E item = arr[front];
            arr[front++] = null;
            size--;
            if (size <= arr.length/4) {
                resizing(size*2);
            }
            return item;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyQueueException();
        }
    }
}