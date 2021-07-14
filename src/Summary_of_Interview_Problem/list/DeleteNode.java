package Summary_of_Interview_Problem.list;

public class DeleteNode {

    public static void deleteNode(ListNode node) {

        while (node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(9);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        DeleteNode.deleteNode(n2);

        ListNode cur = head;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}

