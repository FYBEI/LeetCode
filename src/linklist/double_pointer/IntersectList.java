package linklist.double_pointer;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class IntersectList {

    //相交列表的尾部相同
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        //先遍历两个列表，求出其长度
        int n = 0;
        int m = 0;
        ListNode now = headA;
        while (now != null) {
            now = now.next;
            n++;
        }
        now = headB;
        while (now != null) {
            now = now.next;
            m++;
        }

        //求出长度之差，接着先移动较长的那个链表，使它们处于同样长度的其实点
        int temp = Math.abs(n - m);
        if (n > m) {
            while (temp > 0) {
                headA = headA.next;
                temp--;
            }
        } else {
            while (temp > 0) {
                headB = headB.next;
                temp--;
            }
        }

        //两个链表一起前进，如果相同就返回
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
