package past.binary_tree.traversal;

import past.binary_tree.TreeNode;

import java.util.*;

/**
 * 二叉树的前序遍历
 */
public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        visit(root, result);

        return result;
    }

    private void visit(TreeNode root, List<Integer> result){
        result.add(root.getVal());

        if (root.getLeft() != null){
            visit(root.getLeft(), result);
        }

        if (root.getRight() != null){
            visit(root.getRight(), result);
        }

    }
}
