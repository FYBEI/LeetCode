package jianzhioffer;

import java.util.*;

public class TreePathSum {

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        path(root, target, list);

        return res;
    }

    public void path(TreeNode root, int target, List<Integer> list) {
        // 添加
        list.add(root.val);
        // 叶子节点则判断是否满足
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                res.add(new ArrayList<>(list));
            }
        }

        // 非叶子节点判断之后的路径
        if (root.left != null) {
            path(root.left, target-root.val, list);
        }
        if (root.right != null) {
            path(root.right, target-root.val, list);
        }
        // 回溯
        list.remove(list.size()-1);
    }
}
