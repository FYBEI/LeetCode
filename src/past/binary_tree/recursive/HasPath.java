package past.binary_tree.recursive;

import past.binary_tree.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPath {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return process(root, sum, 0);
    }

    private boolean process(TreeNode root, int sum, int num){
        num += root.getVal();

        //如果到达叶子结点，进行判断
        if (root.getRight() == null && root.getLeft() == null){
            if (sum == num){
                return true;
            }else {
                return false;
            }
        }

        boolean left = false;
        boolean right = false;

        //如果存在左右结点，递归
        if (root.getLeft() != null){
            left = process(root.getLeft(), sum, num);
        }
        if (root.getRight() != null){
            right = process(root.getRight(), sum, num);
        }

        //返回左右结点结果的或
        return left||right;
    }
}
