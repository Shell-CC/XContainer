package container;

import java.util.Iterator;

@SuppressWarnings(value="unchecked")
public class ResizableArray<E> implements Iterable<E> {
    protected E[] arr;
    protected int size;


    /**
     * Create a dynamic resizing array.
     * @param capacity initial size of the array
     */
    public ResizableArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        arr = (E[]) new Object[capacity];
        size = 0;
    }
    /**
     * Create a dynamic resizing array with default size = 10.
     */
    public ResizableArray() {
        this(10);
    }


    /**
     * Return the number of elements in the resizable array
     * @return number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Resize the capacity
     * @param capacity new capacity to be resized to.
     */
    public void resizing(int capacity) {
        E[] newArr = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


    /**
     * check if the resizing array is empty
     * @return true if it is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns an iterator over the elements in the resizing array.
     * @return iterator over the elements.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = 0;
            public boolean hasNext() {  return i < size;  }
            public E next() {  return arr[i++];  }
            public void remove() {}
        };
    }
}