package linklist.classic;

import linklist.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 建立虚拟头节点
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        int i = 0;

        // leftPre定位为left前一个，rightNext定位为right下一个
        ListNode cur = fakeHead;
        ListNode leftPre = fakeHead;
        ListNode rightNext = fakeHead;

        while (i <= right){
            if (i == left-1){
                leftPre = cur;
            }

            cur = cur.next;
            i++;
        }

        rightNext = cur;

        // leftPre的next指向rightNext
        ListNode node = leftPre.next;
        leftPre.next = rightNext;

        // 将leftPre和rightNext之间的节点，插入到leftPre之后
        for (int j = 1; j <= right-left+1; j++){
            ListNode next = node.next;

            ListNode leftNext = leftPre.next;
            leftPre.next = node;
            node.next = leftNext;

            node = next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(5);
        head.next = node;

        ReverseBetween rb = new ReverseBetween();
        rb.reverseBetween(head, 1, 2);
    }
}
