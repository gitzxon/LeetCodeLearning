package study.list.single;

import java.util.List;

/**
 * 用的时候从这里复制过去。
 */
public class Util {
    public static int getLen(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count += 1;
            p = p.next;
        }
        return count;
    }

    public static ListNode[] map(List<ListNode> listNodes) {
        ListNode[] result = new ListNode[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i++) {
            result[i] = listNodes.get(i);
        }
        return result;
    }

    /**
     * input head, return new head, which is the tail in the origin list
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }

        head.next = null;
        return pre;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode p = start;
        ListNode pre = null;
        while (p != end) {
            if (p == start) {
                pre = p;
                pre.next = null;
                p = p.next;
            } else {
                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
        }

        p.next = pre;
        return p;
    }
}

