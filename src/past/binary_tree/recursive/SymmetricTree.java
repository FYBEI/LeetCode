package past.binary_tree.recursive;

import past.binary_tree.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return isSym(root.getLeft(), root.getRight());
    }

    private boolean isSym(TreeNode t1, TreeNode t2){

        boolean case1 = t1 == null;
        boolean case2 = t2 == null;

        //左右结点都为空，说明对称
        if (case1 && case2){
            return true;
        }
        //左右结点中的一个为空，说明不对称
        if (case1 || case2){
            return false;
        }
        //左右结点的值不一致，说明不对称
        if (t1.getVal() != t2.getVal()) {
            return false;
        }

        //左节点的左和右节点的右比较，左节点的右和右节点的左比较
        return isSym(t1.getLeft(), t2.getRight()) && isSym(t1.getRight(), t2.getLeft());
    }
}
