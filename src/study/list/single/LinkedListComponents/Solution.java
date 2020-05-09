package study.list.single.LinkedListComponents;

import study.list.single.ListNode;

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
        for (int aG : G) {
            exist[aG] = true;
        }

        ListNode p = head;
        int count = 0;
        while (p != null) {
            if(!exist[p.val]) {
                p = p.next;
                continue;
            }
            count++;
            while(p.next!=null && exist[p.next.val]) p = p.next;
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