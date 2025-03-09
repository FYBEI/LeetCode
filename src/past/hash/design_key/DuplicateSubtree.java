package past.hash.design_key;

import past.binary_search_tree.TreeNode;

import java.util.*;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 */
public class DuplicateSubtree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        /**
         后续遍历二叉树, 先考虑子树的结构才能了解这颗树的结构, 用map保存二叉树后序遍历字符串出现的次数,
         未出现过则存入map, 重复出现就加1, 但只在次数等于1时加入返回序列中以避免重复.
         **/
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        postorder(root, new HashMap<>(), ret);
        return ret;
    }

    private String postorder(TreeNode r, Map<String, Integer> map, List<TreeNode> ret) {
        if (r == null) {
            return "#";
        }
        String serial = r.val + "," + postorder(r.left, map, ret) + "," + postorder(r.right, map, ret);

        if (map.getOrDefault(serial, 0) == 1) {
            ret.add(r);
        }

        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
