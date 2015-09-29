package container;

/**
 * Implement a min heap.
 */
public class BinaryHeap<E extends Comparable<E>> {
    private E[] arr;   // arr[0] not used
    int N;          // arr[1, N] used

    /**
     * Creates a binary heap.
     * @param capacity The initial capacity of the heap.
     */
    @SuppressWarnings(value="unchecked")
    public BinaryHeap(int capacity) {
        arr = (E[]) new Comparable[capacity + 1];
        N = 0;
    }

    /**
     * Creates a binary heap with initial capacity 15.
     */
    public BinaryHeap() {
        this(15);
    }

    private void exch(int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * Bottom-up reheapify, if the kth element is smaller than its parent.
     */
    private void swim(int k) {
        // exchange the node with its parent until in heap order.
        while (k > 1 && arr[k].compareTo(arr[k/2]) < 0) {
            exch(k, k/2);
            k = k/2;
        }
    }

    /**
     * Top-down reheapify,
     * if the kth element is greater than one or both of its children.
     */
    private void sink(int k) {
        // exchange the node with its smaller node until in heap order.
        int j = 2*k;   // index of the smaller child
        while (j <= N) {
            if (j < N && arr[j].compareTo(arr[j+1]) > 0) j++;
            if (arr[k].compareTo(arr[j]) > 0) {
                exch(j, k);
                k = j;
                j = 2*k;
            } else {
                break;
            }
        }
    }


    /**
     * Return the size of the heap.
     * @return number of elements in the heap.
     */
    public int size() {
        return N;
    }


    /**
     * Check if the heap is empty.
     * @return ture if the heap is empty.
     */
    public boolean isEmpty() {
        return N == 0;
    }


    /**
     * Return the minimal(top) elements in the heap.
     * @return the top element in the heap.
     * @throws EmptyHeapException If the heap is empty.
     */
    public E getMin() {
        if (N == 0) {
            throw new EmptyHeapException();
        }
        return arr[1];
    }


    /**
     * Insert an element into the heap.
     * @param item The element to insert.
     * @return The heap itself.
     */
    @SuppressWarnings(value="unchecked")
    public BinaryHeap<E> insert(E item) {
        if (++N == arr.length) {
            E[] narr = (E[]) new Comparable[N*2];
            System.arraycopy(arr, 0, narr, 0, N);
            arr = narr;
        }
        arr[N] = item;
        swim(N);
        return this;
    }


    /**
     * Retrieve and remove the minimal(top) element in the heap.
     * @return the top element in the heap.
     * @throws EmptyHeapException If the heap is empty.
     */
    @SuppressWarnings(value="unchecked")
    public E extractMin() {
        E min = getMin();
        arr[1] = arr[N];
        arr[N--] = null;
        sink(1);
        if (N <= arr.length/4 && N > 15) {
            E[] narr = (E[]) new Comparable[N*2];
            System.arraycopy(arr, 0, narr, 0, N);
            arr = narr;
        }
        return min;
    }
}

class EmptyHeapException extends RuntimeException {
    public EmptyHeapException() {
    }
}