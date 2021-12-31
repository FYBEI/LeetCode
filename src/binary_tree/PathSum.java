package binary_tree;

import java.util.*;

public class PathSum {
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();

        if (root == null){
            return ans;
        }

        List<Integer> list = new ArrayList<>();
        backTrace(root, targetSum, list);

        return ans;
    }

    private void backTrace(TreeNode root, int targetSum, List<Integer> list){
        targetSum -= root.val;
        list.add(root.val);

        // 到达叶子节点
        if (root.left == null && root.right == null){
            // 如果target为0，则添加
            if (targetSum == 0){
                List<Integer> tmp = new ArrayList<>(list);
                ans.add(tmp);
            }
        }
        if (root.left != null){
            backTrace(root.left, targetSum, list);
        }
        if (root.right != null){
            backTrace(root.right, targetSum, list);
        }

        // 回溯
        list.remove(list.size()-1);
    }
}
