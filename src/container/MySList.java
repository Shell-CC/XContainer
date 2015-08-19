package container;

import java.util.Set;
import java.util.HashSet;

/**
 * Single linked list implementation of the List interface.
 * @author Xiaoxi Shawn Guo
 * @version 0.1
 */

public class MySList {

    private MySListNode head;
    private int size;

    /**
     * Constructs an empty list
     *
     */
    public MySList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the number of items in the list.
     * @return the number of items in the list
     */
    public int size() {
        return size;
    }

    private MySListNode item(int n) {
        for (MySListNode node = head; node != null; node = node.next) {
            if (n-- == 0) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Insert the item at the specific position in the list
     *
     * @param index index of the item to add to
     * @param item item to be added to the list
     * @throws IndexOutOfBoundsException When index &gt;= size || index &lt; 0
     */
    public void add(int index, int item) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            head = new MySListNode(item, head);
        } else {
            MySListNode node = item(index-1);
            node.next = new MySListNode(item, node.next);
        }
        size++;
    }
    /**
     * Inserts the item at the begining of the list
     * @param item item to be added to the list
     */
    public void addFirst(int item) {
        head = new MySListNode(item, head);
        size++;
    }
    /**
     * Appends the item at the end of the list
     * @param item item to be added to the list
     */
    public void addLast(int item) {
        if (head == null) {
            head = new MySListNode(item);
        } else {
            MySListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new MySListNode(item);
        }
        size++;
    }


    /**
     * Return the item at the specific position of the list.
     * @param index When it is non-negative, index from 0 to size-1;
     * When it is negative, index from -size to -1.
     * @return item at the position
     * @throws IndexOutOfBoundsException If index &gt; = size || index &lt; -size)
     */
    public MySListNode get(int index) {
        if (index >= 0) {
            return item(index);
        } else {
            MySListNode node1 = head;
            MySListNode node2 = item(-index-1);
            while (node2.next != null) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
    }


    /**
     * Remove the item at the specific position
     * @param index When it is non-negative, index from 0 to size-1;
     * When it is negative, index from -size to -1.
     * @throws IndexOutOfBoundsException If index &gt; = size || index &lt; -size)
     */
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else if (index > 0){
            MySListNode prev = item(index - 1);
            if (prev.next == null) {
                throw new IndexOutOfBoundsException();
            }
            prev.next = prev.next.next;
        } else {
            MySListNode node1 = head;
            MySListNode node2 = head;
            try {
                while (index < 0) {
                    node2 = node2.next;
                    index++;
                }
            } catch (NullPointerException e) {
                throw new IndexOutOfBoundsException();
            }
            if (node2 == null) {
                head = head.next;
            } else {
                while (node2.next != null) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                node1.next = node1.next.next;
            }
        }
        size--;
    }
    /**
     * Given access to the specific item in the list, remove it.
     * @param node the item to be removed.
     *
     */
    public void remove(MySListNode node) {
        if (node.next == null) {
            item(size-2).next = null;
        } else {
            node.item = node.next.item;
            node.next = node.next.next;
        }
        size--;
    }
    /**
     * Remove all the occurences of the item from the list, if present
     * @param item item to be removed from the list
     * @return true the item is present
     */
    public boolean removeAll(int item) {
        boolean contains = false;
        while (head != null && head.item == item) {
            contains = true;
            size--;
            head = head.next;
        }
        MySListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.item == item) {
                contains = true;
                size--;
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return contains;
    }


    private MySListNode reverse(MySListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        MySListNode prev = null;
        MySListNode curr = head;
        while (curr != null) {
            MySListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    /**
     * Reverse the list
     */
    public void reverse() {
        head = reverse(head);
    }
    /**
     * Reverse the items between the specific range in the list
     * @param m the index of the first item of the range
     * @param n the index of the last item of the range
     * @throws IndexOutOfBoundsException if m,n not in [0, size-1]
     * @throws IllegalArgumentException if m &gt; n
     */
    public void reverse(int m, int n) {
        if (m > n) {
            throw new IllegalArgumentException();
        }
        try {
            int count = 0;
            MySListNode prev = null;
            MySListNode curr = head;
            while (count < m) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            MySListNode M = curr;
            MySListNode prevM = prev;
            while (count <= n) {
                MySListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (M == head) {
                head.next = curr;
                head = prev;
            } else {
                M.next = curr;
                prevM.next = prev;
            }
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * Rotete the list by k step
     * @param k if k &gt; 0, rotate to right by k step, or rotate to left.
     */
    public void rotate(int k) {
        if (head == null) {
            return;
        }
        k = k % size;
        if (k < 0) {
            k = size + k;
        } else if (k == 0) {
            return;
        }
        MySListNode node1 = head;
        MySListNode node2 = head;
        while (k-- > 0) {
            node2 = node2.next;
        }
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = head;
        head = node1.next;
        node1.next = null;
    }


    /**
     * detect cycle in the list, and return the start node of the cycle if found.
     * @return the start node of the loop if found; or else, null.
     */
    public MySListNode detectCycle() {
        MySListNode slow = head;
        MySListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }


    /**
     * remove cycle in the linked list, if found.
     * @return true if there is a cycle.
     */
    public boolean removeCycle() {
        MySListNode slow = head;
        MySListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (true) {
                    if (slow.next == fast.next) {
                        slow.next = null;
                        break;
                    } else {
                        fast = fast.next;
                        slow = slow.next;
                    }
                }
                return true;
            }
        }
        return false;
    }


    /**
     * remove duplicates in the unsorted linked list, if found.
     * @return true if there is duplicate.
     */
    public boolean removeDuplicates() {
        if (head == null) {
            return false;
        }
        boolean contains = false;
        Set set = new HashSet();
        set.add(head.item);
        MySListNode n = head;
        while (n.next != null) {
            if (set.contains(n.next.item)) {
                n.next = n.next.next;
                size--;
                contains = true;
            } else {
                set.add(n.next.item);
                n = n.next;
            }
        }
        return contains;
    }


    /**
     * Remove duplicates in sorted linked list.
     * @return true if there is duplicate.
     */
    public boolean removeSortedDuplicates() {
        if (head == null) {
            return false;
        }
        boolean flag = false;
        MySListNode n = head;
        while (n.next != null) {
            if (n.next.item == n.item) {
                n.next = n.next.next;
                flag = true;
            } else {
                n = n.next;
            }
        }
        return flag;
    }


    /**
     * Sort the single linked list using merge sort
     *
     */
    public void mergeSort() {
        if (head == null || head.next == null) {
            return;
        }
        // split the list into two equal-size list
        MySList list1 = new MySList();
        list1.head = head;
        list1.size = size/2;
        MySListNode tail1 = item(size/2-1);
        MySList list2 = new MySList();
        list2.head = tail1.next;
        list2.size = size - size/2;
        tail1.next = null;
        System.out.println(list1);
        System.out.println(list2);
        // sort the sublists
        list1.mergeSort();
        list2.mergeSort();
        // merge the sublists
        head = mergeTwoSorted(list1.head , list2.head);
    }
    private MySListNode mergeTwoSorted(MySListNode head1, MySListNode head2) {
        return head1;
    }


    /**
     * Check if the list is palindrome
     * @return true if it is palindrome
     */
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // find the beginning node of the latter half
        MySListNode slow = head;
        MySListNode prevSlow = null;
        MySListNode fast = head;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            prevSlow = slow;
            slow = slow.next;  // skip the middle point
        }
        // reverse the latter half
        prevSlow.next = reverse(slow);
        // compare the first half and the last half
        slow = head;
        fast = prevSlow.next;
        while (fast != null) {
            if (slow.item != fast.item) {
                prevSlow.next = reverse(prevSlow.next);
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        prevSlow.next = reverse(prevSlow.next);
        return true;
    }



     /**
     * 
     *
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");
        for (MySListNode node = head; node != null; node = node.next) {
            builder.append(node.toString());
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        MySList list = new MySList();
        list.add(0, 2);
        list.add(1, 1);
        list.add(2, 1);
        list.add(3, 2);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}