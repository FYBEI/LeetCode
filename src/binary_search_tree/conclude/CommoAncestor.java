package binary_search_tree.conclude;

import binary_search_tree.TreeNode;

public class CommoAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null) {
            return null;
        }

        //如果遇见p或者q返回当前结点
        if(root == p || root == q) {
            return root;
        }

        //如果p和q分布在结点的两侧，就返回该结点
        if (root.val < p.val && root.val > q.val){
            return root;
        }
        if (root.val > p.val && root.val < q.val){
            return root;
        }

        //如果都小于根节点，说明都在左子树；反之，都在右子树
        if (root.val < p.val && root.val < q.val){
            lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > p.val && root.val > q.val){
            lowestCommonAncestor(root.left, p, q);
        }

        return null;
    }
}
