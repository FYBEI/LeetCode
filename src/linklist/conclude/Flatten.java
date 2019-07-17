package linklist.conclude;

import java.util.Stack;

/**
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class Flatten {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;

        while (cur != null){

            //发现存在child的结点
            if (cur.child != null){

                //先判断next是否为空，如果不为空，就存入栈中
                if (cur.next != null){
                    Node next = cur.next;
                    stack.push(next);
                }

                //将child接为cur的next，继续往下遍历
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }

            //如果将全部的child遍历完，就寻找栈中是否存在next，将上一级的next接到末尾，如果没有next，说明遍历结束
            if (cur.next == null){
                if (!stack.empty()){
                    Node next = stack.pop();
                    cur.next = next;
                    next.prev = cur;
                }
            }

            cur = cur.next;
        }

        return head;
    }
}
