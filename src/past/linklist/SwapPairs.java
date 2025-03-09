package past.linklist;

public class SwapPairs {

    // 函数返回交换前后两个节点后的头节点
    public ListNode swapPairs(ListNode head) {

        // 没有节点，或者只有节点的时候，直接返回
        if (head == null || head.next == null){
            return head;
        }

        // 第二个节点
        ListNode next = head.next;
        // 之后的交换节点
        ListNode nextPairs = swapPairs(next.next);
        // 头节点连接之后的交换节点，第二个节点连接头节点
        head.next = nextPairs;
        next.next = head;

        return next;
    }
}
