package linklist;

public class ReverseBidirectionalListNode {
    public BidirectionalListNode reverse(BidirectionalListNode head){
        if (head == null){
            return head;
        }

        BidirectionalListNode pre = head;
        BidirectionalListNode cur = head.next;

        while (cur != null) {
            pre.next = pre.pre;
            pre.pre = cur;

            pre = cur;
            cur = cur.next;
        }
        pre.next = pre.pre;
        pre.pre = cur;

        return pre;
    }

    public static void main(String[] args) {
        ReverseBidirectionalListNode rbln = new ReverseBidirectionalListNode();

        BidirectionalListNode node1 = new BidirectionalListNode(1);
        BidirectionalListNode node2 = new BidirectionalListNode(2);
        BidirectionalListNode node3 = new BidirectionalListNode(3);
        BidirectionalListNode node4 = new BidirectionalListNode(4);
        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = node4;
        node4.pre = node3;

        BidirectionalListNode node = node1;
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

        node = node4;
        while (node != null){
            System.out.print(node.val + " ");
            node = node.pre;
        }
        System.out.println();

        node = rbln.reverse(node1);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
