package study.list.single.PartitionList;

import study.list.single.ListNode;

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode dummyLess = new ListNode(0);
        ListNode dummyOther = new ListNode(0);
        ListNode p = head;

        ListNode lessP = dummyLess;
        ListNode otherP = dummyOther;

        while (p != null) {
            ListNode next = p.next;
            if (p.val < x) {
                lessP.next = p;
                lessP = lessP.next;
            } else {
                otherP.next = p;
                otherP = otherP.next;
            }

            p.next = null;
            p = next;
        }

        lessP.next = dummyOther.next;
        ListNode result = dummyLess.next;
        dummyLess.next = null;
        dummyOther.next = null;
        return result;

    }
}