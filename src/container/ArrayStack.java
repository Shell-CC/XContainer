package container;

import java.util.Iterator;
/**
 * Implement a stack using resizing array
 *
 */
public class ArrayStack<E> extends ResizableArray<E> implements Stack<E>{


    /**
     * Construct a stack with specific capacity
     * @param capacity Initial capacity of the stack
     */
    public ArrayStack(int capacity) {
        super(capacity);
    }
    /**
     * Construct a stack with initial capacity = 10
     */
    public ArrayStack() {
        super(10);
    }


    /**
     * Return the elemennt on the top of the stack without moving it
     * @return the element on top of the stack.
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        try {
            return (E) arr[size-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }


    /**
     * Remove and return the element from the top of the stack.
     * @return the element on top of the stack.
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        try{
            E item = (E) arr[--size];
            arr[size] = null;    // avoid loitering
            if (arr.length > 10 && size <= arr.length/4) {
                resizing(size*2);
            }
            return item;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }


    /**
     * Push(add) the specific element onto the top of the stack.
     * @param element the element to be pushed.
     */
    public void push(E element) {
        if (size == arr.length) {
            resizing(size*2);
        }
        arr[size++] = element;
    }


    /**
     * Returns an iterator over the elements in stack.
     * @return iterator from top to bottom.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = size - 1;
            public boolean hasNext() {  return i >= 0;  }
            @SuppressWarnings("unchecked")
            public E next() {  return (E) arr[i--];  }
            public void remove() {}
        };
    }
}