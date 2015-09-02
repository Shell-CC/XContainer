package container;

class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();
        for (String s : args) {
            stack.push(Integer.valueOf(s));
        }
        for (int i : stack) {
            System.out.println(i);
        }
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
    }
}

class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (String s : args) {
            queue.offer(Integer.valueOf(s));
        }
        for (int i : queue) {
            System.out.println(i);
        }
        System.out.println("poll: " + queue.poll());
        System.out.println("peek: " + queue.peek());
    }
}

class TestMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}


class TestSort {
    public static void main(String[] args) {
        Integer[] a = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(a));
        System.out.println("After sorting:");
        Arrays.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}