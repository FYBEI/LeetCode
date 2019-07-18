package n_ary_tree.recursive;

import n_ary_tree.Node;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int answer = 1;

        answer = topDown(root, 1, answer);

        return answer;
    }

    private int topDown(Node root, int depth, int answer){
        if (root.children == null || root.children.isEmpty()){
            answer = Math.max(answer, depth);
            return answer;
        }

        for (Node child : root.children){
            answer = topDown(child, depth + 1, answer);
        }

        return answer;
    }
}
