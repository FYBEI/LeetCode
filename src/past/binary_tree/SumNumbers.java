package past.binary_tree;

public class SumNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return sum;
        }

        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int val){

        // 每次将当前root.val + val*10传入下一层
        int curVal = root.val + val*10;
        // 如果到达叶子节点，则加入sum
        if (root.right == null && root.left == null){
            sum += curVal;
            return;
        }

        // 朝向有孩子节点的方向遍历
        if (root.left != null){
            dfs(root.left, curVal);
        }
        if (root.right != null){
            dfs(root.right, curVal);
        }

    }
}
