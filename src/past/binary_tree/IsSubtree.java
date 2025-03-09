package past.binary_tree;

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null){
            return true;
        }

        if (root == null || subRoot == null){
            return false;
        }

        if (root.val == subRoot.val && isSub(root, subRoot)){
            return true;
        }else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSub(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }

        if (root == null || subRoot == null){
            return false;
        }

        if (root.val == subRoot.val){
            return isSub(root.left, subRoot.left) && isSub(root.right, subRoot.right);
        }else {
            return false;
        }
    }
}
