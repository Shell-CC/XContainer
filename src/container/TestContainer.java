package container;

import java.util.Iterator;

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
        // preorder
        Object[] order = tree.preorder();
        System.out.print("Preorder: ");
        for (Object c : order) {
            System.out.print(c + " ");
        }
        System.out.println();
        // inorder
        order = tree.inorder();
        System.out.print("Inorder: ");
        for (Object c : order) {
            System.out.print(c + " ");
        }
        System.out.println();
        // postorder
        order = tree.postorder();
        System.out.print("Postorder: ");
        for (Object c : order) {
            System.out.print(c + " ");
        }
        System.out.println();
        // level order
        order = tree.levelorder();
        System.out.print("Level order: ");
        for (Object c : order) {
            System.out.print(c + " ");
        }
        System.out.println();
        // test Iterator
        System.out.print("Inorder iterator: ");
        for (Iterator<Character> it = tree.inorderIterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // test mirror
        tree.toMirror();
        order = tree.levelorder();
        System.out.print("Level order after mirror: ");
        for (Object c : order) {
            System.out.print(c + " ");
        }
        System.out.println();
        // test build tree
        Object[] preorder = {1, 2, 3};
        Object[] inorder = {2, 1, 3};
        Object[] postorder = {2, 3, 1};
        BinaryTree<Integer> tree2= new BinaryTree<>();
        tree2.buildFromPreAndIn(preorder, inorder);
        System.out.print("Inorder after building: ");
        for (Iterator<Integer> it = tree2.inorderIterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        BinaryTree<Integer> tree3= new BinaryTree<>();
        tree3.buildFromPostAndIn(postorder, inorder);
        System.out.print("Inorder after building: ");
        for (Iterator<Integer> it = tree3.inorderIterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
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

class TestBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(30).insert(20).insert(40).insert(70).insert(60).insert(80);
        for (Integer i : bst) {
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 2;
        System.out.println(i +"th element is " + bst.get(i));
        Integer[] sorted = {20, 30, 40, 60, 70, 80};
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.build(sorted);
        System.out.println("BST1 equals BST2? " + bst.equals(bst2));
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


class TestBinaryHeap {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(2);
        heap.insert(4);
        System.out.println(heap.extractMin());
        heap.insert(5).insert(3);
        System.out.println(heap.getMin());
    }
}

class TestStrings {
    public static void main(String[] args) {
        String[] strs = new String[]{"4PGC938", "2IYE230", "3CI0720", "2RLA929"};
        Strings.LsdSort(strs, 7);
        for (String s : strs) {
            System.out.println(s);
        }
    }
}