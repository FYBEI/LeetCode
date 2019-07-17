package linklist.conclude;

import linklist.double_pointer.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;

        int carry = 0;

        //遍历两个链表，求出每一位的和及进位
        while (l1 != null && l2 != null){
            int total = l1.val + l2.val + carry;
            if (total >= 10){
                carry = total / 10;
                total = total % 10;
            }else {
                carry = 0;
            }

            ListNode tmp = new ListNode(total);
            cur.next = tmp;
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        //如果l1没有结束，就继续连接l1后的数字
        while (l1 != null){
            int total = l1.val + carry;
            if (total >= 10){
                carry = total / 10;
                total = total % 10;
            }else {
                carry = 0;
            }

            ListNode tmp = new ListNode(total);
            cur.next = tmp;
            cur = cur.next;

            l1 = l1.next;
        }

        //如果l2没有结束，就连接l2后面的数字
        while (l2 != null){
            int total = l2.val + carry;
            if (total >= 10){
                carry = total / 10;
                total = total % 10;
            }else {
                carry = 0;
            }

            ListNode tmp = new ListNode(total);
            cur.next = tmp;
            cur = cur.next;

            l2 = l2.next;
        }

        //如果最后还剩余数，就多出一位
        if (carry != 0){
            ListNode tmp = new ListNode(carry);
            cur.next = tmp;
        }

        return result.next;
    }
}
