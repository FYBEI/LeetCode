package linklist;

public class SortList {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode node){
        // 0个和1个节点就直接返回
        if (node == null){
            return null;
        }
        if (node.next == null){
            return node;
        }

        // 使用快慢指针定位中间节点
        ListNode pre = new ListNode();
        pre.next = node;
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        // 中间节点的连接部分要截断，形成两个独立的链表
        pre.next = null;

        // 递归的进行二分，并且最终将两个链表归并排序
        ListNode node1 = mergeSort(node);
        ListNode node2 = mergeSort(slow);
        return mergeSort(node1, node2);
    }

    private ListNode mergeSort(ListNode node1, ListNode node2){
        ListNode fakeNode = new ListNode();
        ListNode cur = fakeNode;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else {
                cur.next = node2;
                node2 = node2.next;
            }

            cur = cur.next;
        }

        if (node1 != null){
            cur.next = node1;
        }
        if (node2 != null){
            cur.next = node2;
        }

        return fakeNode.next;
    }

}
