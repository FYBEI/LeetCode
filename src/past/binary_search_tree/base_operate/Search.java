package past.binary_search_tree.base_operate;

import past.binary_search_tree.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 *
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 */
public class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        if (root.val == val){
            return root;
        }

        if (root.val > val){
            return searchBST(root.left, val);
        }

        if (root.val < val){
            return searchBST(root.right, val);
        }

        return root;
    }
}
