package study.list.single.MergeKSortedList;

import study.list.single.ListNode;

import java.util.PriorityQueue;

class Solution {

    // // TODO: 2018/8/7 二分法优化
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListIndexWithValue> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;

            priorityQueue.add(new ListIndexWithValue(i, lists[i].val));
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (priorityQueue.size() != 0) {
            ListIndexWithValue tmp = priorityQueue.poll();
            ListNode cur = lists[tmp.index];
            ListNode next = cur.next;
            if (next != null) {
                priorityQueue.add(new ListIndexWithValue(tmp.index, next.val));
            }
            p.next = cur;
            cur.next = null;
            p = p.next;
            lists[tmp.index] = next;
        }
        return dummy.next;
    }

    private class ListIndexWithValue {
        int index;
        int value;

        public ListIndexWithValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}