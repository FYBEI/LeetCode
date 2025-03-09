package past.linklist;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }

        ListNode tail = head;

        // 定位第k个节点，如果节点数不足k，则直接返回头节点
        for (int i = 1; i < k; i++){
            tail = tail.next;
            if (tail == null){
                return head;
            }
        }

        // 第k+1个节点
        ListNode nextK = tail.next;

        // 假头节点
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        // 反转链表
        ListNode pre = fakeHead;
        ListNode cur = head;
        while (cur != nextK){
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        // head 变为最后一个节点，head连接之后k个节点
        head.next = reverseKGroup(nextK, k);

        return tail;
    }

    public static void main(String[] args) {
        ReverseKGroup rkg = new ReverseKGroup();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        rkg.reverseKGroup(head, 2);
    }
}
