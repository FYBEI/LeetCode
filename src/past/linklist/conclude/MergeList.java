package past.linklist.conclude;

import past.linklist.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        ListNode last = null;
        if (l1 != null){
            last = l1;
        }else if (l2 != null){
            last = l2;
        }

        cur.next = last;

        return result.next;
    }
}
