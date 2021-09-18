package binary_tree;

public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return max;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left + right > max){
            max = left + right;
        }

        return Math.max(left, right) + 1;
    }
}
