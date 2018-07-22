package list.single.LinkedListComponents;

import list.single.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    boolean[] exist;

    public int numComponents(ListNode head, int[] G) {

        int len = getLength(head);
        exist = new boolean[len];
        Arrays.stream(G).forEach(value -> exist[value] = true);

        ListNode p = head;
        boolean found = false;
        int count = 0;
        while (p != null) {
            if (!found) {
                if (exist(p.val)) {
                    found = true;
                    count += 1;
                }
            } else { // found previous
                if (!exist(p.val)) {
                    found = false;
                }
            }

            p = p.next;
        }
        return count;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count += 1;
            p = p.next;
        }
        return count;
    }

    private boolean exist(int value) {
        return exist[value];
    }
}