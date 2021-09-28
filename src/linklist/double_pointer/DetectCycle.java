package linklist.double_pointer;

import linklist.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null){
            return null;
        }

        Map<ListNode,Integer> map = new HashMap<>();
        int pos = -1;

        while(head.next != null){
            if(map.containsKey(head)){
                pos = map.get(head);
                return head;
            }else{
                map.put(head,pos+1);
                head = head.next;
                pos++;
            }
        }
        return null;

    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
