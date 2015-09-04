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
        Arrays.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}


class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Character> tree = new BinaryTree<>();
        initial(tree);
        Object[] inorder = tree.inorder();
        for (Object c : inorder) {
            System.out.println(c);
        }
    }
    private static void initial(BinaryTree<Character> tree) {
        tree.root = tree.new Node<>('+');
        tree.root.left = tree.new Node<>('*');
        tree.root.right = tree.new Node<>('^');
        tree.root.left.left = tree.new Node<>('3');
        tree.root.left.right = tree.new Node<>('7');
        tree.root.right.left = tree.new Node<>('4');
        tree.root.right.right = tree.new Node<>('2');
    }
}


class TestResizableArray {
    public static void main(String[] args) {
        ResizableArray<Integer> arr = new ResizableArray<>(2);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(arr.get(1));
        Object[] a = arr.toArray();
        for (Object i : a) {
            System.out.println(i);
        }
    }
}