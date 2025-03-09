package past.binary_tree.conclude;

import past.binary_tree.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class CommoAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        }

        //如果遇见p或者q返回当前结点
        if(root == p || root == q) {
            return root;
        }

        //判断p和q存在左子树还是右子树，如果一边的子树不含有这两个结点就返回null
        TreeNode left = lowestCommonAncestor(root.getLeft(),p,q);
        TreeNode right = lowestCommonAncestor(root.getRight(),p,q);

        //如果p和q分别存在于左右子树，返回当前结点
        if(left != null && right != null) {
            return root;
        }

        //如果左子树不为null，说明这两个结点都在左子树中
        if(left != null) {
            return left;
        }
        //如果右子树不为null，说明这两个结点都在右子树中
        if(right != null) {
            return right;
        }

        //如果都不在，就返回null
        return null;
    }

}
