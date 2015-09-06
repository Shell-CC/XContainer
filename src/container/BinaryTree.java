package container;

class BinaryTree<E> {

    Node<E> root;


    /**
     * Return the number of elements in the tree.
     * @return number of elements.
     */
    public int size() {
        return root.size();
    }

    /**
     * Preorder Traverse the binary tree.
     * @return Array of all the elements in preorder.
     */
    public Object[] preorder() {
        return preorderIterative();
    }
    private Object[] preorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.preorder(arr);
        return arr.toArray();
    }
    private Object[] preorderIterative() {
        @SuppressWarnings("unchecked")
        E[] order = (E[]) new Object[size()];
        Stack<Node<E>> stack = new ArrayStack<>();
        stack.push(root);
        int i = 0;
        while (!stack.isEmpty()) {
            Node<E> n = stack.pop();
            order[i++] = n.data;
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        return order;
    }


    /**
     * Inorder Traverse the binary tree.
     * @return Array of all the elements in inorder.
     */
    public Object[] inorder() {
        return inorderIterative();
    }
    private Object[] inorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.inorder(arr);
        return arr.toArray();
    }
    private Object[] inorderIterative() {
        @SuppressWarnings("unchecked")
        E[] inorder = (E[]) new Object[size()];
        Stack<Node<E>> stack = new ArrayStack<>();
        Node<E> curr = root;   // node of traversal
        int i = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            while (curr == null && !stack.isEmpty()) {
                Node<E> n = stack.pop();    // node to be added.
                inorder[i++] = n.data;
                if (n.right != null) {
                    curr = n.right;
                }
            }
        }
        return inorder;
    }


    /**
     * Postorder Traverse the binary tree.
     * @return Array of all the elements in postorder.
     */
    public Object[] postorder() {
        return postorderIterative();
    }
    private Object[] postorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.postorder(arr);
        return arr.toArray();
    }
    private Object[] postorderIterative() {
        @SuppressWarnings("unchecked")
        E[] postorder = (E[]) new Object[size()];
        Stack<Node<E>> stack = new ArrayStack<>();
        stack.push(root);
        int i = postorder.length - 1;
        while (!stack.isEmpty()) {
            Node<E> n = stack.pop();
            postorder[i--] = n.data;
            if (n.left != null) {
                stack.push(n.left);
            }
            if (n.right != null) {
                stack.push(n.right);
            }
        }
        return postorder;
    }


    /**
     * Level-order (BFS) Traverse the binary tree.
     * @return An Array of all the elements in level order.
     */
    public Object[] levelorder() {
        return levelorderIterative();
    }
    private Object[] levelorderIterative() {
        @SuppressWarnings("unchecked")
        E[] levelorder = (E[]) new Object[size()];
        Queue<Node<E>> queue = new ArrayQueue<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            levelorder[i++] = n.data;
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
        return levelorder;
    }
    private Object[] levelorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>(size());
        int level = 1;
        while (arr.size() < size()) {
            getLevel(root, level, arr);
            level++;
        }
        return arr.toArray();
    }


    /**
     * Return all the elements in the specific level.
     * @param level The specific level to be traversed.
     * @return An array of elements in the specific level.
     * @throws IllegalArgumentException If level &lt;= 0.
     */
    public Object[] getLevel(int level) {
        ResizableArray<E> arr = new ResizableArray<>();
        getLevel(root, level, arr);
        return arr.toArray();
    }
    private void getLevel(Node<E> root, int level, ResizableArray<E> arr) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            arr.add(root.data);
        } else if (level > 1){
            getLevel(root.left, level - 1, arr);
            getLevel(root.right, level - 1, arr);
        } else {
            throw new IllegalArgumentException();
        }
    }



    /**
     * Binary Tree Node.
     * No null data is allowed.
     */
    class Node<E> {
        private E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E data) {
            this.data = data;
        }

        /**
         * Return the number of nodes in the tree whose root is this node.
         */
        public int size() {
            int size = 1;
            size += left == null ? 0 : left.size();
            size += right == null ? 0 : right.size();
            return size;
        }

        /**
         * Traverse the descendants of this node and store them in an array.
         */
        public void inorder(ResizableArray<E> arr) {
            if (left != null) {
                left.inorder(arr);
            }
            arr.add(data);
            if (right != null) {
                right.inorder(arr);
            }
        }
        public void preorder(ResizableArray<E> arr) {
            arr.add(data);
            if (left != null) {
                left.preorder(arr);
            }
            if (right != null) {
                right.preorder(arr);
            }
        }
        public void postorder(ResizableArray<E> arr) {
            if (left != null) {
                left.postorder(arr);
            }
            if (right != null) {
                right.postorder(arr);
            }
            arr.add(data);
        }
    }

}