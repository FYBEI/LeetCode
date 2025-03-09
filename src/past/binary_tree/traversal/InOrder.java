package past.binary_tree.traversal;

import past.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        visit(root, result);

        return result;
    }

    private void visit(TreeNode root, List<Integer> result){
        if (root.getLeft() != null){
            visit(root.getLeft(), result);
        }

        result.add(root.getVal());

        if (root.getRight() != null){
            visit(root.getRight(), result);
        }

    }
}
