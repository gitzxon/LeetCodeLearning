package study.list.single.LinkedListCycleII;

import study.list.single.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
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


        if (!foundCycle) {
            return null;
        } else {
            boolean entryPointFound = false;
            slow = head;
            while (!entryPointFound) {
                if (fast == slow) {
                    entryPointFound = true;
                    break;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            return slow;
        }


    }
}