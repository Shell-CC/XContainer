package container;

class BinaryTree<T> extends AbstractTree<T> {
    class Node<T> {
        private T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> root;
}