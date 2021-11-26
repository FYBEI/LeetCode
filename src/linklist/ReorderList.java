package linklist;

public class ReorderList {

    /**
     * 方法一：遍历链表，并且使用数组保存每一个节点，在从头尾两端分别连接
     */
    public void reorderList(ListNode head) {
        ListNode[] link = new ListNode[50000];

        int n = 0;
        while (head != null){
            link[n++] = head;
            head = head.next;
        }

        int i = 1;
        int j = n - 1;
        boolean flag = false;
        ListNode cur = link[0];

        while (i <= j){
            if (flag){
                cur.next = link[i++];
                cur = cur.next;
                flag = false;
            }else {
                cur.next = link[j--];
                cur = cur.next;
                flag = true;
            }
        }

        cur.next = null;
    }

    /**
     * 方法二：找到链表的中间节点，将链表后半部分倒转，在合并链表
     */
    public void reorderList2(ListNode head) {
        ListNode l1 = head;
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;

        l2 = reverse(l2);

        mergeList(l1, l2);
    }

    // 使用快慢指针获得中间节点
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 倒转链表
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode newhead = head;

        while (cur != null){
            head.next = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = head.next;
        }

        return newhead;
    }

    // 合并链表
    private void mergeList(ListNode l1, ListNode l2){
        ListNode cur = l1;
        l1 = l1.next;
        boolean flag = false;

        while (l1 != null || l2 != null){
            if (flag){
                cur.next = l1;
                l1 = l1.next;
                flag = false;
            }else {
                cur.next = l2;
                l2 = l2.next;
                flag = true;
            }

            cur = cur.next;
        }
    }
}
