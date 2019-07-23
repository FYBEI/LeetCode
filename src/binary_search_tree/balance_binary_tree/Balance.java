package binary_search_tree.balance_binary_tree;

import binary_search_tree.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Balance {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return false;
        }

        int index = gethigh(root);
        return (index != -1);
    }

    private int gethigh(TreeNode root){

        if (root == null)
        {
            return 0;
        }

        int left = 0, right = 0;
        if (root.left != null)
        {
            left = gethigh(root.left);
        }
        if (left != -1  && root.right != null)
        {
            right = gethigh(root.right);
        }
        if (left != -1 && right != -1)
        {
            int diff = Math.abs(left - right);
            if (diff <= 1)
            {
                return ((left > right) ? left : right) + 1;
            }
        }
        return -1;

    }
}
