package random_problem;

import Summary_of_Interview_Problem.list.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        ListNode last = null;
        if (l1 != null){
            last = l1;
        }else if (l2 != null){
            last = l2;
        }

        cur.next = last;

        return result.next;

    }
}
