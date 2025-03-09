package past.hash.one;


public class MyHashSet {

    class HashNode{
        private int val;
        public HashNode next;
        public HashNode pre;
        public HashNode(int val){
            this.val = val;
        }
    }

    private HashNode[] set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new HashNode[1000];
    }

    public void add(int key) {
        int hash = key % set.length;
        if (contains(key)) {
            return;
        }

        HashNode newNode = new HashNode(key);
        if (set[hash] == null) {
            set[hash] = newNode;
        } else {
            HashNode headNode = set[hash];
            if (headNode.next == null) {
                headNode.next = newNode;
                newNode.pre = headNode;
                newNode.next = null;
            } else {
                newNode.next = headNode.next;
                newNode.pre = headNode;
                headNode.next.pre = newNode;
                headNode.next = newNode;
            }
        }
    }

    public void remove(int key) {
        int hash = key % set.length;
        if (set[hash] == null) {
            return;
        }
        HashNode node = findNodeInArr(key);
        if (node == null) {
            return;
        }
        if (node.next == null && node.pre == null) {
            set[hash] = null;
        } else if (node.next == null && node.pre != null) {
            node.pre.next = null;
        } else if (node.next != null && node.pre == null) {
            set[hash] = node.next;
        } else if (node.next != null && node.pre != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (findNodeInArr(key) == null){
            return false;
        }else {
            return true;
        }
    }

    private HashNode findNodeInArr(int key){
        HashNode node = set[key % set.length];
        if (node == null) {
            return null;
        }
        do {
            if (node.val == key) {
                return node;
            }
        } while ((node = node.next) != null);
        return null;
    }
}
