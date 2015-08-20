package container;

import java.util.Iterator;

@SuppressWarnings(value="unchecked")
public class ResizableArray<E> implements Stack<E>, Iterable<E> {
    private E[] arr;
    private int size;


    public ResizableArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        arr = (E[]) new Object[capacity];
        size = 0;
    }
    public ResizableArray() {
        this(10);
    }


    public int size() {
        return size;
    }


    public void resizing(int capacity) {
        E[] newArr = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public E peek() {
        return arr[size-1];
    }


    public E pop() {
        return arr[--size];
    }


    public void push(E element) {
        if (size == arr.length) {
            resizing(size*2);
        }
        arr[size++] = element;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = size - 1;
            public boolean hasNext() {  return i >= 0;  }
            public E next() {  return arr[i--];  }
            public void remove() {}
        };
    }
}