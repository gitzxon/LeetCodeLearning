package study.list.single.RemoveDuplicatesFromLinkedList;

import study.list.single.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;

        Integer valueToDelete = null;
        while (p != null) {
            if (valueToDelete == null) {
                if (sameValueAsNext(p)) {
                    valueToDelete = p.val;
                    continue;
                } else {
                    // move next at the same time
                    p = p.next;
                    pre = pre.next;
                    continue;
                }
            } else {
                if (p.val == valueToDelete) {
                    // delete cur
                    pre.next = p.next;
                    p.next = null;
                    p = pre.next;
                    continue;
                } else {
                    valueToDelete = null;
                    continue;
                }
            }
        }

        return dummy.next;
    }

    private boolean sameValueAsNext(ListNode p) {
        return p.next != null && p.val == p.next.val;
    }

}