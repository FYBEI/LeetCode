package linklist;

import linklist.classic.OddEvenList;
import linklist.classic.PalindromeList;
import linklist.classic.RemoveNode;
import linklist.classic.ReverseList;
import linklist.conclude.Flatten;
import linklist.conclude.MergeList;
import linklist.conclude.Node;
import linklist.conclude.RotateRight;
import linklist.double_pointer.DeleteNode;
import linklist.singlelist.MyLinkedList;
import org.junit.Assert;
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

    @Test
    public void reverseList(){
        ReverseList reverseList = new ReverseList();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode head = a1;
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println(" ");

        ListNode reverse = reverseList.reverseList(a1);
        head = reverse;
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    @Test
    public void removeNode(){
        RemoveNode removeNode = new RemoveNode();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        a1.next = a2;

        ListNode head = a1;

        ListNode result = removeNode.removeElements(head, 1);

        Assert.assertNull(result);
    }

    @Test
    public void oddeven(){
        OddEvenList oddEvenList = new OddEvenList();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode head = a1;

        ListNode result = oddEvenList.oddEvenList(head);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    @Test
    public void palindrom(){
        PalindromeList palindromeList = new PalindromeList();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode head = a1;

        boolean result = palindromeList.isPalindrome(head);

        Assert.assertTrue(result);
    }

    @Test
    public void merger(){
        MergeList mergeList = new MergeList();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        ListNode result = mergeList.mergeTwoLists(a1, b1);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    @Test
    public void flatten(){
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        Node a7 = new Node(7);
        Node a8 = new Node(8);
        Node a9 = new Node(9);
        Node a10 = new Node(10);
        Node a11 = new Node(11);
        Node a12 = new Node(12);

        a1.child = a2;
        a2.child = a3;
        a3.child = a4;
        a4.child = a5;
        a5.child = a6;
        a6.child = a7;
        a7.child = a8;
        a8.child = a9;
        a9.child = a10;
        a10.child = a11;
        a11.child = a12;

        Node head = a1;

        Flatten flatten = new Flatten();
        Node result = flatten.flatten(head);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    @Test
    public void rotate(){
        RotateRight rotateRight = new RotateRight();

        ListNode a1 = new ListNode(1);

        ListNode result = rotateRight.rotateRight(a1, 1);

        System.out.print(result.val);
    }
}
