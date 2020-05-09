package study.list.single.CopyRandomList;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {

            Node next = cur.next;

            Node newNode = new Node();
            newNode.val = cur.val;

            cur.next = newNode;
            newNode.next = next;

            cur = next;
        }

        Node p1 = head;
        while (p1 != null) {
            if (p1.random != null) {
                p1.next.random = p1.random.next;
            }

            p1 = p1.next.next;
        }


        Node oldP = head;
        Node newP = head.next;
        Node newHead = head.next;

        while (oldP != null && newP != null) {
            oldP.next = newP.next;
            if (oldP.next != null) {
                newP.next = oldP.next.next;
            }

            oldP = oldP.next;
            newP = newP.next;
        }
        return newHead;
    }
}
