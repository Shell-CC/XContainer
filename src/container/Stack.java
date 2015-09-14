package container;

/**
 * Interface of LIFO stack.
 */
public interface Stack<E> extends Iterable<E>{


    /**
     * Push(add) the specific element onto the top of the stack.
     * @param element the element to be pushed.
     */
    public abstract void push(E element);


    /**
     * Remove and return the element from the top of the stack.
     * @return the element on top of the stack.
     */
    public abstract E pop();


    /**
     * Return the elemennt on the top of the stack without moving it
     * @return the element on top of the stack.
     */
    public abstract E peek();


    /**
     * Check if the stack is empty.
     * @return true if it is empty, or else false
     */
    public abstract boolean isEmpty();


    /**
     * Return the number of elements in the stack.
     * @return the number of elements in the stack.
     */
    public abstract int size();
}

class EmptyStackException extends RuntimeException {
    public EmptyStackException() {}
}