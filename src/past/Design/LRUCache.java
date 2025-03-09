package past.Design;

import java.util.*;

public class LRUCache {

    private Map<Integer, DLinkNode> map;
    private int capacity;   // 容量
    private int count;  // 当前数量

    /**
     * 双向链表表示最近使用情况
     */
    private DLinkNode head;
    private DLinkNode tail;

    private class DLinkNode {
        DLinkNode pre;
        DLinkNode next;
        int key;
        int value;

        DLinkNode() {}
        DLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;

        // 伪头部和伪尾部，防止移动节点的时候，当节点在头部或尾部回造成出界
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 判断是否包含key
        if (!map.containsKey(key)) {
            return -1;
        }

        DLinkNode node = map.get(key);
        // 更新使用队列
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        // map未包含该key
        if (!map.containsKey(key)){
            DLinkNode node = new DLinkNode(key, value);

            map.put(key, node);
            addToHead(node);
            count++;

            // 若超过容量，删除队列首项
            if (count > capacity){
                DLinkNode tail = removeTail();
                map.remove(tail.key);
                count--;
            }
        }else {
            DLinkNode node = map.get(key);
            node.value = value;

            moveToHead(node);
        }
    }

    private void removeNode(DLinkNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addToHead(DLinkNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail(){
        DLinkNode node = tail.pre;

        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
