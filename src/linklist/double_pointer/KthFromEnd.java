package linklist.double_pointer;

public class KthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
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
        int n;
        // 偶数个节点
        if (fast == null){
            n = (i - 1) * 2;
        }else {
            n = i * 2 - 1;
        }

        // 目标位置
        int target = n - k + 1;

        // 目标位置在中间之后
        if (target > i){
            for (;i < target; i++){
                slow = slow.next;
            }
        }else if(target == i){
            return slow;
        }
        // 目标位置在中间之前
        else {
            slow = head;
            for (i = 1; i < target; i++){
                slow = slow.next;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        KthFromEnd kth = new KthFromEnd();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = kth.getKthFromEnd(head, 4);
        System.out.println(node.val);
    }
}
