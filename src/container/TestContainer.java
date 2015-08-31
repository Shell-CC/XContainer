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