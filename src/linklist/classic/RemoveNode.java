package linklist.classic;

import linklist.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveNode {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }

        ListNode pre = new ListNode(0);
        ListNode result = pre;
        pre.next = head;
        ListNode cur = head;

        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return result.next;
    }
}
