package binary_search_tree;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        return isValid(root.left, Long.MIN_VALUE, (long) root.val) && isValid(root.right, (long) root.val, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, Long min, Long max){
        if (node == null){
            return true;
        }

        if (min >= node.val || node.val >= max){
            return false;
        }

        return isValid(node.left, min, (long) node.val) && isValid(node.right, (long) node.val, max);
    }
}
