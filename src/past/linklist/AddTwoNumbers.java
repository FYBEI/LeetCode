package past.linklist;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int add){
        if (l1 == null && l2 == null && add == 0){
            return null;
        }

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        int val = val1 + val2 + add;
        if (val >= 10) {
            val -= 10;
            add = 1;
        }else {
            add = 0;
        }

        ListNode node = new ListNode(val);
        ListNode next1 = l1 == null ? null : l1.next;
        ListNode next2 = l2 == null ? null : l2.next;
        node.next = add(next1, next2, add);

        return node;
    }
}
