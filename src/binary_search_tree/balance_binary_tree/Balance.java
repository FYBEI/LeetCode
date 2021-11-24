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
        if (getHeigh(root) == -1){
            return false;
        }

        return true;
    }

    // 返回树的高度，-1代表树是不平衡的
    private int getHeigh(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = getHeigh(root.left);
        int right = getHeigh(root.right);

        // 左右子树有一个不是平衡的，则这棵树是不平衡的
        if (left == -1 || right == -1){
            return -1;
        }

        // 左右子树高度差距大于1，则不平衡；否则返回该树的高度
        if (Math.abs(left - right) > 1){
            return -1;
        }else {
            return Math.max(left, right) + 1;
        }
    }
}
