package container;

public class LinkedStack<E> extends AbstractLinkedList<E> implements Stack<E> {

    /**
     * Construct a stack.
     */
    public LinkedStack() {
        super();
    }


    /**
     * Return the elemennt on the top of the stack without moving it
     * @return the element on top of the stack.
     */
    public E peek() {
        try {
            return super.head.item;
        } catch (NullPointerException e) {
            throw new EmptyStackException();
        }
    }


    /**
     * Remove and return the element from the top of the stack.
     * @return the element on top of the stack.
     */
    public E pop() {
        try {
            E top = head.item;
            head = head.next;
            size--;
            return top;
        } catch (NullPointerException e) {
            throw new EmptyStackException();
        }
    }


    /**
     * Push(add) the specific element onto the top of the stack.
     * @param element the element to be pushed.
     */
    public void push(E element) {
        head = new LinkedNode(element, head);
        size++;
    }
}