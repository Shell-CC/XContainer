package container;

public class MySListNode {

    int item;
    MySListNode next;

    public MySListNode(int item, MySListNode next) {
        this.item = item;
        this.next = next;
    }

    public MySListNode(int item) {
        this(item, null);
    }

    public String toString() {
        return "Node:" + item + " ";
    }
}