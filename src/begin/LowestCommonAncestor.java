package begin;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 如果遇见其中一个节点直接返回
        // 假设q是p的子节点，那么遇见p会直接返回，p就是p和q的公共祖先，p的父节点在另一侧是返回null的
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // 查找左右子树，会有两种情况
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

        // 在左右字数分别找到了两个节点，说明两个目标节点分布在左右两边，那么当前节点就是最近公共祖先
        // 如果只在一侧返回，说明最近公共祖先在这一侧下面，就是这一侧的返回值
        if (leftChild != null && rightChild != null) {
            return root;
        }else {
            return leftChild != null ? leftChild : rightChild;
        }
    }
}
