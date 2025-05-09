package past.linklist.conclude;

import past.linklist.ListNode;

/**
 *给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }

        if (head.next == null){
            return head;
        }

        //base cases
        if(head == null) {
            return null;
        }
        if(head.next == null){
            return head;
        }
        //close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n=1; old_tail.next != null ; n++){
            old_tail = old_tail.next;
        }

        //形成环
        old_tail.next = head;

        //find new tail: (n -k%n -1)th node 新链的开始节点 第（n-k%n-1）个结点
        //and new head: (n-k%n)th node       新链的头节点是
        ListNode new_tail = head;
        for(int i =1 ; i <= n-k%n -1; i++){
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        //break the ring
        new_tail.next = null;
        return new_head;
    }
}
