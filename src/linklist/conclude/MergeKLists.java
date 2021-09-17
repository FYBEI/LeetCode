package linklist.conclude;

import linklist.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n == 0){
            return null;
        }

        if (n == 1){
            return lists[0];
        }

        return merge(lists, 0, n-1);
    }

    private ListNode merge(ListNode[] lists, int l, int r){
        if (l == r){
            return lists[l];
        }

        if (l > r){
            return null;
        }

        int mid = (l + r) >> 1;
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode mergeTwo(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null && cur2 != null){

            if (cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }

            cur = cur.next;
        }

        if (cur1 != null){
            cur.next = cur1;
        }else if (cur2 != null){
            cur.next = cur2;
        }

        return head.next;
    }

}
