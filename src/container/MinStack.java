package container;

/**
 * A special stack that supports retriving mininal item in constant time.
 *
 */
public class MinStack extends ArrayStack<Integer> implements Stack<Integer> {
    Stack<Integer> minStack;

    /**
     * Construct an empty MinStack.
     */
    public MinStack() {
        super();
        minStack = new ArrayStack<>();
    }


    /**
     * Push(add) the specific element onto the top of the stack.
     * @param x The element to be pushed.
     */
    public void push(int x) {
        super.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }


    /**
     * Remove and return the element from the top of the stack.
     * @return the element on top of the stack.
     */
    public Integer pop() {
        int x = super.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
        return x;
    }


    /**
     * Retrive the minimal element in the stack.
     * @return the minimal element in the stack.
     */
    public int getMin() {
        return minStack.peek();
    }
}