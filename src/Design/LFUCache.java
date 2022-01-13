package Design;

import java.util.*;

public class LFUCache {

    class Node {
        int key;
        int val;
        int num;
        Node next;
        Node pre;

        public Node () {}

        public Node (int key, int val){
            this.key = key;
            this.val = val;
            this.num = 1;
        }
    }

    private Map<Integer, Node> map;
    private int count = 0;
    private int capacity;
    private Node head;
    private Node tail;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.num++;

            removeNode(node);
            insertFromHead(node);

            return node.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0){
            return;
        }

        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            node.num++;

            removeNode(node);
            insertFromHead(node);

        }else {
            Node node = new Node(key, value);
            count++;

            if (count > capacity){
                Node remove = removeTail();
                map.remove(remove.key);
                count--;
            }

            map.put(key, node);
            insertFromHead(node);
        }
    }

    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private Node removeTail(){
        Node remove = tail.pre;
        tail.pre = remove.pre;
        remove.pre.next = tail;

        return remove;
    }

    private void insertFromHead(Node node){
        Node cur = head.next;

        // 定位第一个 node.num >= cur.num 的位置，将node插入其前面
        while (cur != null && node.num < cur.num){
            cur = cur.next;
        }

        cur.pre.next = node;
        node.pre = cur.pre;
        cur.pre = node;
        node.next = cur;
    }

    private void insertFromTail(Node node){
        Node cur = tail.pre;

        // 定位第一个 node.num < cur.num 的位置，将node插入其后面
        while (cur != head && node.num >= cur.num){
            cur = cur.pre;
        }

        cur.next.pre = node;
        node.next = cur.next;
        cur.next = node;
        node.pre = cur;
    }

    private void print(){
        Node cur = head.next;
        while (cur != tail){
            System.out.print(cur.val);
            System.out.print(' ');
            cur = cur.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);
        lfu.put(1,1);
        lfu.put(2,2);

        lfu.print();

        lfu.get(2);
        lfu.print();
        lfu.get(1);
        lfu.print();
        lfu.get(2);
        lfu.print();

        lfu.put(3,3);
        lfu.print();
        lfu.put(4,4);
        lfu.print();

        lfu.get(3);
        lfu.print();
        lfu.get(2);
        lfu.print();
        lfu.get(1);
        lfu.print();
        lfu.get(4);
    }
}
