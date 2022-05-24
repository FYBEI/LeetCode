package jianzhioffer;

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        // 以当前A根节点开始匹配，如果不匹配，则再从A的左右子节点为根节点匹配
        if (isSub(A, B)) {
            return true;
        }else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 根节点的值不匹配
        if (A.val != B.val) {
            return false;
        }

        // 继续匹配左右子树节点
        boolean left = true;
        boolean right = true;
        if (B.left != null) {
            left = isSub(A.left, B.left);
        }
        if (B.right != null) {
            right = isSub(A.right, B.right);
        }

        return left && right;
    }
}
