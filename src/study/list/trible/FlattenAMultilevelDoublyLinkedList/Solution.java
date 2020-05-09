package study.list.trible.FlattenAMultilevelDoublyLinkedList;


import study.list.trible.Node;

public class Solution {
    public Node flatten(Node head) {
        return helper(head);
    }

    private Node helper(Node head) {

        Node p = head;
        while (p != null) {
            if (p.child != null) {
                Node next = p.next;
                Node newTail = mergeChild(p);
                if (next != null) {
                    newTail.next = next;
                    next.prev = newTail;
                }
            }
            p = p.next;
        }

        return head;
    }

    private Node mergeChild(Node cur) {
        if (cur == null) return null;
        if (cur.child == null) return cur;

        Node lastChild = findLastChild(cur);
        Node fstChild = cur.child;
        cur.next = fstChild;
        fstChild.prev = cur;
        cur.child = null;
        return lastChild;
    }

    private Node findLastChild(Node cur) {
        if (cur.child == null) return null;
        Node p = cur.child;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

}
