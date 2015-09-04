package container;

class BinaryTree<E> {

    /**
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
            size += left==null?0:left.size();
            size += right==null?0:right.size();
            return size;
        }

        /**
         * Traverse the descendants of this node and store them in an array.
         *
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
    }

    Node<E> root;


    /**
     * Return the number of elements in the tree.
     * @return number of elements.
     */
    public int size() {
        return root.size();
    }

    /**
     * Inorder Traverse the binary tree.
     * @return Array of all the tree nodes in inorder.
     */
    public Object[] inorder() {
        ResizableArray<E> arr = new ResizableArray<>();
        root.inorder(arr);
        return arr.toArray();
    }
}