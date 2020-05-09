package study.list.single.AddTwoNumbersII;

import study.list.single.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);
        int len1 = getLen(reverseL1);
        int len2 = getLen(reverseL2);

        ListNode p1;
        ListNode p2;
        if (len1 >= len2) {
            p1 = reverseL1;
            p2 = reverseL2;
        } else {
            p1 = reverseL2;
            p2 = reverseL1;
        }
        ListNode resultToReturn = p1;


        int carry = 0;
        ListNode preP1 = null;
        while (p1 != null && (p2 != null || carry != 0)) {
            int a = getValue(p1);
            int b = getValue(p2);
            int sum = a + b + carry;
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }

            p1.val = sum;
            preP1 = p1;
            p1 = p1.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry != 0) {
            preP1.next = new ListNode(1);
            preP1 = preP1.next;
        }

        if (len1 > len2) {

        }

        return reverse(resultToReturn);
    }

    public int getValue(ListNode listNode) {
        if (listNode == null) {
            return 0;
        } else {
            return listNode.val;
        }
    }


    public static int getLen(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count += 1;
            p = p.next;
        }
        return count;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }

        head.next = null;
        return pre;
    }
}