package linklist.double_pointer;

import linklist.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class DeleteNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode suf = head;

        //suf先走n步
        for (int i = n; i > 0; i--) {
            suf = suf.next;
        }

        //一共m个结点，suf走完n步后，pre和suf一起走，则pre走了m-n步
        //即pre为倒数第n个的前一个结点
        while (suf != null) {
            pre = pre.next;
            suf = suf.next;
        }

        //如果pre没走，说明倒数第n个为头节点
        if (pre.next != head) {
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
