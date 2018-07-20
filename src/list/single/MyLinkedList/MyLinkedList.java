package list.single.MyLinkedList;


class MyLinkedList {

    int capacity;
    ListNode head;
    ListNode tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (empty()) {
            init(val);
        } else {
            ListNode cur = new ListNode(val);
            cur.next = head;
            head = cur;
            capacity += 1;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (empty()) {
            init(val);
        } else {
            ListNode cur = new ListNode(val);
            tail.next = cur;
            tail = tail.next;
            capacity += 1;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > capacity) {
            return;
        } else if (index == capacity) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            ListNode pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            ListNode newListNode = new ListNode(val);
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }

    private void init(int val ) {
        ListNode cur = new ListNode(val);
        head = cur;
        tail = cur;
        capacity = 1;
    }

    private boolean empty() {
        return head == null && tail == null;
    }


    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */