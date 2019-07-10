package queue_stack.queue;

import javafx.beans.property.SimpleSetProperty;

import java.util.*;

/**
 * 广度优先遍历算法
 */
public class BFS {

    /**
     * 代表树的结点
     */
    class Node{

    }

    /**
     * Return the length of the shortest path between root and target node.
     */
    int BFS(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        queue.add(root);
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.peek();

                if (cur.equals(target)){
                    return step;
                }

                //the neighbors of cur
                List<Node> curs = new ArrayList<>();
                for (Node next : curs) {
                    queue.add(next);
                }
                queue.remove();
            }
        }
        return -1;          // there is no path from root to target
    }

    /**
     * Return the length of the shortest path between root and target node.
     */
    int BFS2(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
        Set<Node> used = new SimpleSetProperty<>();     // store all the used nodes
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        queue.add(root);
        used.add(root);
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.peek();
                if (cur.equals(target)){
                    return step;
                }

                //the neighbors of cur
                List<Node> curs = new ArrayList<>();
                for (Node next : curs) {
                    if (!used.contains(next)) {
                        queue.add(next);
                        used.add(next);
                    }
                }
                queue.remove();
            }
        }
        return -1;          // there is no path from root to target
    }
}
