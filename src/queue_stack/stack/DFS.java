package queue_stack.stack;

import java.util.*;

/**
 * 在大多数情况下，我们在能使用 BFS 时也可以使用 DFS。但是有一个重要的区别：遍历顺序。
 * 与 BFS 不同，更早访问的结点可能不是更靠近根结点的结点。因此，你在 DFS 中找到的第一条路径可能不是最短路径。
 */
public class DFS {
    class Node{

    }

    /**
     * Return true if there is a path from cur to target.
     * 递归方法实现dfs,使用系统调用栈
     * @param cur
     * @param target
     * @param visited
     * @return
     */
    static boolean DFS(Node cur, Node target, Set<Node> visited) {
        if (cur.equals(target)){
            return true;
        }

        List<Node> neighbor = new ArrayList<>();
        for (Node next : neighbor) {
            if (!visited.contains(next)) {
                visited.add(next);

                if (DFS(next, target, visited)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 使用 while 循环和栈来模拟递归期间的系统调用栈
     * @param root
     * @param target
     * @return
     */
    boolean DFS(Node root, int target) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node cur = s.pop();

            if (cur.equals(target)){
                return true;
            }

            List<Node> neighbors = new ArrayList<>();
            for (Node next : neighbors) {
                if (!visited.contains(next)) {
                    s.push(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }
}
