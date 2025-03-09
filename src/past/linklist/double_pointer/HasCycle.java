package past.linklist.double_pointer;

import past.linklist.ListNode;

/**
 * 判断是否是环形链表
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {

        //只有头指针或者没有头指针都不是
        if (head == null || head.next == null) {
            return false;
        }

        //双指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            //如果快指针先到达链表尾部，说明不是环形
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
