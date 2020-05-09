package study.list.single.SplitLinkedListInParts;

import study.list.single.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {

        int len = getLen(root);
        int baseLen = len / k;
        int remain = len % k;

        List<Integer> partLenList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            partLenList.add(baseLen);
        }

        for (int i = 0; i < remain; i++) {
            partLenList.set(i, partLenList.get(i) + 1);
        }

        List<ListNode> resultContainer = new ArrayList<>();

        ListNode curHead = root;
        for (Integer integer : partLenList) {
            ListNode p = curHead;
            ListNode result = curHead;
            resultContainer.add(result);
            if (curHead == null) {
                continue;
            }
            for (Integer i = 0; i < integer - 1; i++) {
                p = p.next;
            }
            curHead = p.next;
            p.next = null;
        }


        return map(resultContainer);
    }

    public static ListNode[] map(List<ListNode> listNodes) {
        ListNode[] result = new ListNode[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i++) {
            result[i] = listNodes.get(i);
        }
        return result;
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
}