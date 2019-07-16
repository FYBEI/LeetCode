package linklist.singlelist;

public class MyLinkedList {
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    private Node head;
    private int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        count = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (count - 1 < index){
            return -1;
        }

        if (index < 0){
            return -1;
        }

        Node target = head;
        for (int i = 0; i < index; i++){
            target = target.next;
        }

        return target.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (count == 0){
            head = new Node(val);
            count++;
            return;
        }

        Node newHead = new Node(val);

        newHead.next = head;
        head = newHead;
        count++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (count == 0){
            head = new Node(val);
            count++;
            return;
        }

        Node tmp = head;
        do{
            if (tmp.next == null){
                Node tail = new Node(val);
                tmp.next = tail;
                break;
            }
            tmp = tmp.next;
        }while (true);
        count++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if (index > count){
            return;
        }

        if (index == count){
            addAtTail(val);
            return;
        }

        if (index <= 0){
            addAtHead(val);
            return;
        }

        Node insert = new Node(val);
        Node cur = head;
        for (int i = 0; i < index-1; i++){
            cur = cur.next;
        }
        Node next = cur.next;
        cur.next = insert;
        insert.next = next;
        count++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0){
            return;
        }

        if (index > count-1){
            return;
        }

        if (index == 0 && count == 1){
            head = null;
            count--;
            return;
        }

        if (index == 0){
            head = head.next;
            count--;
            return;
        }

        Node pre = head;
        for (int i = 0; i < index-1; i++){
            pre = pre.next;
        }
        Node delete = pre.next;

        pre.next = delete.next;
        delete = null;
        count--;
    }
}
