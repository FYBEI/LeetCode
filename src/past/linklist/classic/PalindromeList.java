package past.linklist.classic;

import past.linklist.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 输入: 1->2
 * 输出: false
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }

        if (head.next == null){
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode quick = head;

        //快指针走两步，慢指针走一步，则快指针到达终点时慢指针走一半
        //慢指针每次走完，将next反转指向prev，将前半部分的链表反转
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //quick为null说明链表含有偶数个结点，此时的slow停在n/2+1处；不为null则含有奇数个结点，次数slow停在正中间
        //center取到互文开始点
        if (quick != null){
            slow = slow.next;
        }

        while (slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
