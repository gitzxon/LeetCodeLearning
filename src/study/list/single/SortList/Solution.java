package study.list.single.SortList;

import study.list.single.ListNode;
import study.list.single.ListNodeExtKt;

import java.util.stream.Collectors;

class Solution {
    public ListNode sortList(ListNode head) {
        return recursionHelper(head);

    }

    public ListNode recursionHelper(ListNode head) {

        if (head == null || head.next == null) return head;

        String headStr = ListNodeExtKt.toArrayList(head).stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("headStr = " + headStr);

        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = null;

        while (fast != null && fast.next != null) {
            preSlow = slow;
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        preSlow.next = null;

        ListNode head1 = head;
        ListNode head2 = slow;
        head1 = recursionHelper(head1);
        head2 = recursionHelper(head2);

        return mergeSortedList(head1, head2);
    }

    public ListNode mergeSortedList(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        String str1 = ListNodeExtKt.toArrayList(head1).stream().map(Object::toString).collect(Collectors.joining(", "));
        String str2 = ListNodeExtKt.toArrayList(head2).stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        ListNode merge = new ListNode(0);
        ListNode result = merge;

        while (p1 != null && p2 != null) {

            if (p1.val < p2.val) {
                merge.next = p1;
                p1 = p1.next;

            } else {
                merge.next = p2;
                p2 = p2.next;
            }

            merge = merge.next;

        }

        ListNode remain;
        if (p1 != null) {
            merge.next = p1;
        }
        if (p2 != null) {
            merge.next = p2;
        }

        ListNode tmp = result;
        result = result.next;
        tmp.next = null;
        return result;

    }
}