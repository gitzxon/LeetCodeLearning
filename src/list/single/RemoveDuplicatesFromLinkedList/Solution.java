package list.single.RemoveDuplicatesFromLinkedList;

import list.single.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        Integer valueToDelete = null;

        while (p != null && (p.next != null || valueToDelete != null && valueToDelete == p.val)) {
            if (p.next != null && p.val == p.next.val) {
                valueToDelete = p.val;
            }

            if (valueToDelete != null && p.val == valueToDelete) {
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }
}