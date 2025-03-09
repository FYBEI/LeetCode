package past.linklist;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        ListNode pre = fakeHead;
        ListNode cur = head;

        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return fakeHead.next;
    }
}
