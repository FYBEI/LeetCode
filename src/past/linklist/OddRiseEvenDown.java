package past.linklist;

public class OddRiseEvenDown {

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        // 奇偶链表的头节点
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode cur = head.next.next;
        ListNode oddCur = oddHead;
        ListNode evenTail = evenHead;

        // 分离奇偶节点，偶节点逆序插入
        boolean flag = true;
        while (cur != null){
            if (flag){
                oddCur.next = cur;
                oddCur = oddCur.next;
                cur = cur.next;
                flag = false;
            }else {
                ListNode next = cur.next;

                cur.next = evenHead;
                evenHead = cur;
                cur = next;

                flag = true;
            }
        }
        oddCur.next = null;
        evenTail.next = null;

        // 合并两个链表
        ListNode fakeHead = new ListNode();
        cur = fakeHead;
        while (oddHead != null || evenHead != null){
            int oddValue = oddHead == null ? Integer.MAX_VALUE : oddHead.val;
            int evenValue = evenHead == null ? Integer.MAX_VALUE : evenHead.val;

            if (oddValue < evenValue){
                cur.next = oddHead;
                oddHead = oddHead.next;
            }else {
                cur.next = evenHead;
                evenHead = evenHead.next;
            }
            cur = cur.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        OddRiseEvenDown ored = new OddRiseEvenDown();

        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.next;
        }

        cur = ored.sort(head);

        System.out.println();
        while (cur != null){
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.next;
        }
    }
}
