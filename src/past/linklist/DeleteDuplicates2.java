package past.linklist;

public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode fakeHead = new ListNode();
        ListNode cur = fakeHead;

        // 两个节点记录节点的val值是否一样，两个指针标记两个节点的位置
        int i = 0;
        int j = 1;
        ListNode node = head;
        ListNode next = head.next;

        while (next != null){
            // 如果两个节点值一样，移动后一个节点
            if (next.val == node.val){
                next = next.next;
                j++;
            }
            // 如果两个节点值不一样，则通过指针判断其中间的节点数量
            else {

                // 如果节点数量只有1，则说明node节点不重复，则可以连接在当前节点之后，否则不连接
                // 然后移动两个节点和指针，node节点移动到next节点处，next节点从其下一位开始
                if (j-i == 1){
                    cur.next = node;
                    cur = cur.next;
                }
                node = next;
                i = j;
                next = next.next;
                j++;
            }
        }

        // 由于最后next==null，需要额外判断一次节点数量，是否需要接入链表之后
        if (j - i == 1){
            cur.next = node;
            cur = cur.next;
        }
        // 链表的尾部应该为null，避免之前节点的next节点影响
        cur.next = null;

        return fakeHead.next;
    }

}
