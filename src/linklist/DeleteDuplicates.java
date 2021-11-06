package linklist;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        int num = head.val;
        // node1定位原链表，node2定位新链表
        ListNode node1 = head.next;
        ListNode node2 = head;

        while (node1 != null){
            if (node1.val != num){
                num = node1.val;
                node2.next = node1;
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        node2.next = null;

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        DeleteDuplicates dd = new DeleteDuplicates();
        dd.deleteDuplicates(head);
    }
}
