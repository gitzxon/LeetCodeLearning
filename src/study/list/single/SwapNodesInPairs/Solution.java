package study.list.single.SwapNodesInPairs;

import study.list.single.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode result = null;
        ListNode pre = null;
        while (p != null && p.next != null) {

            ListNode nextNext = p.next.next;
            ListNode next = p.next;

            p.next.next = p;
            p.next = nextNext;


            if (p == head) {
                result = next;
            }
            if (pre != null) {
                pre.next = next;
            }
            pre = p;
            p = nextNext;
        }

        return result;
    }


}