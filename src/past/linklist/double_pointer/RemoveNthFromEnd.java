package past.linklist.double_pointer;

import past.linklist.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 1;

        // 双指针：一个快指针一个慢指针，当快指针走到尾端或者超界时，慢指针走到中间，计数器记录中间长度
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            i++;
        }

        // 链表长度
        int len;
        // 偶数个节点
        if (fast == null){
            len = (i - 1) * 2;
        }else {
            len = i * 2 - 1;
        }

        // 目标位置
        int target = len - n + 1;

        // 如果目标为头节点，直接返回head.next
        if (target == 1){
            return head.next;
        }

        // slow节点的前一个节点
        ListNode pre;
        // 目标位置在中间之后
        if (target > i){
            pre = slow;
            for (int j = i; j < target; j++){
                if (j > i){
                    pre = pre.next;
                }
                slow = slow.next;
            }
        }
        // 目标位置在中间之前
        else if(target < i){
            pre = head;
            slow = head;
            for (int j = 1; j < target; j++){
                if (j > 1){
                    pre = pre.next;
                }
                slow = slow.next;
            }
        }else {
            pre = head;
            while (pre.next != slow){
                pre = pre.next;
            }
        }

        remove(pre, slow);

        return head;
    }

    // 移除节点
    private void remove(ListNode pre, ListNode node){
        pre.next = node.next;
    }
}
