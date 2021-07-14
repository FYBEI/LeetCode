package Summary_of_Interview_Problem.tree;

public class BinaryTreeKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int result = 0;

        int rightNum = getChildNum(root.right);
        if (rightNum == k-1){
            result = root.val;
        }else if (rightNum < k-1){
            result = kthSmallest(root.left, k-rightNum-1);
        }else if (rightNum > k-1){
            result = kthSmallest(root.right, k);
        }

        return result;
    }

    private int getChildNum(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftNum = getChildNum(root.left);
        int rightNum = getChildNum(root.right);
        return leftNum + rightNum + 1;
    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(4);
            root.left = node3;
            root.right = node1;
            node1.left = node2;

            BinaryTreeKthSmallest btk = new BinaryTreeKthSmallest();
            int result = btk.kthSmallest(root, 4);
            System.out.print(result);
    }
}
