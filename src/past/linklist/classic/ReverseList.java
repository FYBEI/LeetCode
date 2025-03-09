package past.linklist.classic;

import past.linklist.ListNode;

/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode newhead = head;

        while (cur != null){
            head.next = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = head.next;
        }

        return newhead;
    }
}
