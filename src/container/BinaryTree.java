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
    public E[] preorder() {
        return preorderIterative();
    }
    private Object[] preorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.preorder(arr);
        return arr.toArray();
    }
    private E[] preorderIterative() {
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
    public E[] inorder() {
        return inorderIterative();
    }
    private Object[] inorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.inorder(arr);
        return arr.toArray();
    }
    private E[] inorderIterative() {
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
    public E[] postorder() {
        return postorderIterative();
    }
    private Object[] postorderRecursive() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.postorder(arr);
        return arr.toArray();
    }
    private E[] postorderIterative() {
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