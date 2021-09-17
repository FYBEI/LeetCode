package linklist.classic;

import linklist.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null){
            return head;
        }

        //标记cur所在位置
        int index = 0;

        ListNode cur = head;
        ListNode next = head.next;

        //链表第二个点，即第一个奇数点
        ListNode second = head.next;

        //每个点的next连到后两个点
        //如果next到达末尾，判断这是cur为在奇数点还是偶数点，如果在偶数点，cur的next为second；如果在奇数点，即next在偶数点，next的next为second
        while (next != null){
            cur.next = next.next;

            if (next.next != null){
                cur = next;
                next = next.next;
                index++;
            }else {
                if (index % 2 == 0){
                    cur.next = second;
                }else {
                    next.next = second;
                }
                break;
            }

        }

        return head;

    }
}
