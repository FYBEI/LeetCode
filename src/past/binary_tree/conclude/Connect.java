package past.binary_tree.conclude;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Connect {

    //使用bfs算法
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int nodes = queue.size();

            Node pre = null;
            for(int i = 0; i < nodes; i++){
                Node cur = queue.poll();
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                cur.next = pre;
                pre = cur;
            }
        }

        return root;
    }

    //dfs算法
    public Node connect2(Node root) {
        List<Node> left = new LinkedList<>();
        dfs(root, 1, left);
        return root;
    }

    private void dfs(Node node, int level, List<Node> left) {
        if(node == null) {return;}
        if(level > left.size()) {
            left.add(node);
        } else {
            Node nodeLeft = left.get(level - 1);
            nodeLeft.next = node;
            left.set(level - 1, node);
        }
        dfs(node.left, level + 1, left);
        dfs(node.right, level + 1, left);
    }
}
