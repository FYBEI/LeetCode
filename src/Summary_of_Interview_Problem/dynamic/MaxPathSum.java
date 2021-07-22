package Summary_of_Interview_Problem.dynamic;

import Summary_of_Interview_Problem.tree.TreeNode;

public class MaxPathSum {

    // 记录最长路径
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxPath;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int total = root.val + left + right;

        // 更新最长路径
        maxPath = Math.max(maxPath, total);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-2);
        TreeNode node6 = new TreeNode(-1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.left = node6;

        int sum = maxPathSum.maxPathSum(root);
        System.out.print(sum);
    }
}
