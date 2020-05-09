package study.list.single.ReverseLinkedListII;

import study.list.single.ListNode;

// Note: 1 ≤ m ≤ n ≤ length of list.
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m >= n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preM = dummy;
        ListNode p = head;

        ListNode nodeM = null;
        ListNode nodeN = null;
        ListNode afterN = null;
        int counter = 1;
        while (p != null) {

            if (counter == m) {
                nodeM = p;
            } else if (counter == n) {
                nodeN = p;
                afterN = p.next;
                break;
            }

            if (nodeM == null) {
                preM = p;
            }

            p = p.next;
            counter += 1;
        }

        reverse(nodeM, nodeN);
        preM.next = nodeN;
        nodeM.next = afterN;
        return dummy.next;

    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode p = start;
        ListNode pre = null;
        while (p != end) {
            if (p == start) {
                pre = p;
                p = p.next;
                pre.next = null;
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