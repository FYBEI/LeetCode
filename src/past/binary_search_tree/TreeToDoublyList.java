package past.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeToDoublyList {

    /**
     * 深度遍历
     */
    public Node treeToDoublyList_DFS(Node root) {
        Node head = treeToList(root);

        if (head == null){
            return null;
        }

        Node cur = head;
        while (cur.right != null){
            cur = cur.right;
        }

        cur.right = head;
        head.left = cur;
        return head;
    }

    private Node treeToList(Node root){
        if (root == null){
            return null;
        }

        Node head = root;
        Node pre = treeToList(root.left);
        Node next = treeToList(root.right);

        if (pre != null){
            head = pre;
            Node cur = pre;
            while (cur.right != null){
                cur = cur.right;
            }
            cur.right = root;
            root.left = cur;
        }

        if (next != null){
            root.right = next;
            next.left = root;
        }

        return head;
    }

    /**
     * 广度遍历
     */
    Queue<Node> queue = new LinkedList<>();
    public Node treeToDoublyList_BFS(Node root) {
        if (root == null){
            return null;
        }

        bfs(root);

        Node head = queue.poll();
        Node cur = head;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            cur.right = node;
            node.left = cur;
            cur = node;
        }
        cur.right = head;
        head.left = cur;
        return head;
    }

    private void bfs(Node root){
        if (root == null){
            return;
        }
        bfs(root.left);
        queue.add(root);
        bfs(root.right);
    }
}
