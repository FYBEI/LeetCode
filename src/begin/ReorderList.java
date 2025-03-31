package begin;

public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        int n = 0;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            n++;
        }

        ListNode node = head;
        ListNode midPre = reverse(slow);
        while (n > 0) {
            ListNode next = node.next;
            node.next = midPre.next;
            midPre.next = node;
            midPre = node.next;
            node = next;
            n--;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = new ListNode();
        while (node != null) {
            ListNode next = node.next;
            node.next = pre.next;
            pre.next = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
//        ListNode node5 = new ListNode(5);
//        node4.next = node5;

        reorderList(head);
    }
}
