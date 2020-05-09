package study.list.single.ReverseNodesInKGroup;

import study.list.single.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1 || k == 0) return head;

        ListNode dummy = new ListNode(0);
        ListNode subHead;
        ListNode subTail;
        dummy.next = head;

        subHead = head;
        subTail = dummy;
        subTail = move(subTail, k);
        if (subTail == null) return dummy.next;

        ListNode headPre = dummy;
        ListNode tailNext = subTail.next;

        while (subTail != null) {

            ListNode[] pair = revert(subHead, subTail);
            subHead = pair[0];
            subTail = pair[1];

            headPre.next =subHead;
            subTail.next = tailNext;


            headPre = subTail;
            subHead = subTail.next;

            subTail = move(subTail, k);
            if (subTail == null) return dummy.next;

            tailNext = subTail.next;
        }

        return dummy.next;
    }

    /**
     * move from a ListNode to a ListNode,
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode move(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p == null) {
                return null;
            }
            p = p.next;
        }
        return p;
    }

    public ListNode[] revert(ListNode head, ListNode tail) {
        ListNode[] result = new ListNode[2];
        if (head == null || head.next == null || head == tail) {
            result[0] = tail;
            result[1] = head;
            return result;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        ListNode end = tail.next;
        while (cur != null && cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;

        result[0] = pre;
        result[1] = head;
        return result;
    }
}