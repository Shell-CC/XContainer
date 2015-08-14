
public class MySListNode {

    Object item;
    MySListNode next;

    public MySListNode(Object item, MySListNode next) {
        this.item = item;
        this.next = next;
    }

    public MySListNode(Object item) {
        this(item, null);
    }

    public String toString() {
        return "Node:" + item.toString() + " ";
    }
}