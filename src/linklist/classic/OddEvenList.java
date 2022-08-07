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

        // 奇偶头节点
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();

        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;
        ListNode cur = head;

        // 标记奇偶位，true为奇数位，false为偶数位
        boolean flag = true;

        while(cur != null){
            if (flag){
                oddCur.next = cur;
                oddCur = oddCur.next;
                flag = false;
            }else {
                evenCur.next = cur;
                evenCur = evenCur.next;
                flag = true;
            }

            cur = cur.next;
        }
        // 末尾连接null，避免循环链表
        oddCur.next = null;
        evenCur.next = null;

        // 奇数链表末尾连接偶数链表头
        oddCur.next = evenHead.next;
        return oddHead.next;
    }
}
