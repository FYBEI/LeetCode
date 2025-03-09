package past.jianzhioffer;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (isBal(root) == -1) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 返回-1表示非平衡，返回大于-1的数表示该树的深度
     * @param root
     * @return
     */
    public int isBal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBal(root.left);
        int right = isBal(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }else {
            return -1;
        }
    }
}
