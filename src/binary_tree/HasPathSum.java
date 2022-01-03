package binary_tree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        return backTrace(root, targetSum);
    }

    private boolean backTrace(TreeNode node, int targetSum){
        targetSum -= node.val;

        if (node.left == null && node.right == null){
            if (targetSum == 0){
                return true;
            }
        }

        boolean left = false;
        boolean right = false;
        if (node.left != null){
            left = backTrace(node.left, targetSum);
        }
        if (node.right != null){
            right = backTrace(node.right, targetSum);
        }

        return left||right;
    }
}
