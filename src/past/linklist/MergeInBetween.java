package past.linklist;

public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        int i = 0;
        ListNode cur = list1;

        // 定位到第 a-1 个节点
        for (; i < a-1; i++){
            cur = cur.next;
        }

        // 保存cur.next，将cur.next连接list2
        i++;
        ListNode cur2 = cur.next;
        cur.next = list2;

        // 定位到第 b+1 个节点
        for (; i < b+1; i++){
            cur2 = cur2.next;
        }

        // 定位list2的尾节点
        cur = list2;
        while (cur.next != null){
            cur = cur.next;
        }

        cur.next = cur2;

        return list1;
    }
}
