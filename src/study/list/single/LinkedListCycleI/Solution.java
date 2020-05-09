package study.list.single.LinkedListCycleI;

import study.list.single.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean foundCycle = false;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                foundCycle = true;
                break;
            }
        }

        return foundCycle;
    }
}