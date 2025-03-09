package past.linklist.conclude;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 */
public class RandomList {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node node = head;
        //复制next节点，将每个新节点放置在node节点的next处，形成 node -> newNode -> next -> nextNewNode
        while (node != null) {
            Node next = node.next;
            Node temp = new Node(node.val, next, null);
            node.next = temp;
            node = next;
        }
        //复制random节点，每个新节点的random应该指向新的节点，node.random为原random节点，node.random.next为新节点
        node = head;
        while (node != null) {
            if(node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }

        //删除原来的链表，将原node节点next指向原next，新节点指向新的next，形成 node -> next，newNode -> nextNewNode
        node = head;
        Node newNode = head.next;
        while (node.next != null) {
            Node next = node.next;
            node.next = next.next;
            node = next;
        }
        return newNode;
    }

    public static void main(String[] args){
        RandomList randomList = new RandomList();

        Node a1 = new Node();
        Node a2 = new Node();

        a1.val = 1;
        a2.val = 2;
        a1.next = a2;
        a1.random = a2;
        a2.random = a2;

        Node result = randomList.copyRandomList(a1);

        while (result != null){
            System.out.println("result:" + result + " val:" + result.val + ", next:" + result.next + ", random:" + result.random);

            result = result.next;
        }
    }
}
