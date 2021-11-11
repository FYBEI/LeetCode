package linklist;

public class BidirectionalListNode {
    public int val;
    public BidirectionalListNode next;
    public BidirectionalListNode pre;

    public BidirectionalListNode() {}
    public BidirectionalListNode(int x) {
        val = x;
        next = null;
        pre = null;
    }
    public BidirectionalListNode(int x, BidirectionalListNode next, BidirectionalListNode pre) {
        val = x;
        this.next = next;
        this.pre = pre;
    }
}
