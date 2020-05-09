package study.list.single.Reorder;

import study.list.single.ListNode;

class Solution {
    public void reorderList(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }

        ListNode mid;
        if (fast == null ){
            mid = slow;
        } else {
            mid = slow.next;
            preSlow = preSlow.next;
        }

        preSlow.next = null;

        ListNode result = dummy;
        dummy.next = null;
        ListNode head2 = reverse(mid);

        ListNode p1 = head;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            result.next = p1;
            result = result.next;
            p1 = p1.next;
            result.next = null;

            result.next = p2;
            result = result.next;
            p2 = p2.next;
            result.next = null;
        }

        if (p1 != null) {
            result.next = p1;
            result = result.next;
            p1 = p1.next;
            result.next = null;
        }

    }

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
}