package linklist;

import linklist.double_pointer.DeleteNode;
import linklist.double_pointer.ListNode;
import linklist.singlelist.MyLinkedList;
import org.junit.Test;

public class Run {

    @Test
    public void linkList(){
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        linkedList.get(1);
        linkedList.deleteAtIndex(0);
        linkedList.get(0);
    }

    @Test
    public void deleteNode(){
        DeleteNode deleteNode = new DeleteNode();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        a1.next = a2;

        ListNode result = deleteNode.removeNthFromEnd(a1, 1);

    }
}
