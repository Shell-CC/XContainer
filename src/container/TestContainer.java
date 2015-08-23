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