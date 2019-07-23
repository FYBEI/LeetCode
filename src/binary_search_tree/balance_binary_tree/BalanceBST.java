package binary_search_tree.balance_binary_tree;

import binary_search_tree.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class BalanceBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        TreeNode root = getChild(nums, left, right);

        return root;
    }

    private TreeNode getChild(int[] nums, int left, int right){
        if (left == right){
            TreeNode node = new TreeNode(nums[left]);
            return node;
        }
        if (left > right){
            return null;
        }

        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = getChild(nums, left, mid-1);
        node.right = getChild(nums, mid + 1, right);
        return node;
    }
}
