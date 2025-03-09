package past.jianzhioffer;

import java.util.*;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);

        // 使用字典将复制前后的节点相互对应
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node pre = dummy;

        // 复制新节点
        while (cur != null) {
            Node node = new Node(cur.val);
            pre.next = node;
            pre = pre.next;

            map.put(cur, node);
            cur = cur.next;
        }

        // 设置新节点的random
        Node cur2 = dummy.next;
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                Node r = map.get(cur.random);
                cur2.random = r;
            }

            cur = cur.next;
            cur2 = cur2.next;
        }

        return dummy.next;
    }
}
