package begin;

public class LRUCache {

    static class Node {
        private int key;
        private int value;
        private Node next;
        private Node pre;
    }

    private final Node[] nodes;

    private final Node head;

    private final Node tail;

    private final int capacity;

    private int cnt;

    public LRUCache(int capacity) {
        this.nodes = new Node[10_000+1];
        this.capacity = capacity;
        this.cnt = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (nodes[key] == null) {
            return -1;
        }

        Node node = nodes[key];
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodes[key] != null) {
            Node node = nodes[key];
            node.value = value;
            removeNode(node);
            addNode(node);
            return;
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        addNode(node);

        if (cnt > capacity) {
            removeNode(tail.pre);
        }
    }

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;

        nodes[node.key] = node;
        cnt++;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        nodes[node.key] = null;
        cnt--;
    }
}
