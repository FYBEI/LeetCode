package past.binary_tree.recursive;

import past.binary_tree.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int answer = 1;

        answer = topDown(root, 1, answer);

        return answer;
    }

    private int topDown(TreeNode root, int depth, int answer){

        if (root.getLeft() == null && root.getRight() == null){
            answer = Math.max(answer, depth);
            return answer;
        }

        if (root.getLeft() != null){
            answer = topDown(root.getLeft(), depth+1, answer);
        }
        if (root.getRight() != null){
            answer = topDown(root.getRight(), depth+1, answer);
        }

        return answer;
    }
}
