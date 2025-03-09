package past.Summary_of_Interview_Problem.tree;

import java.util.ArrayList;

public class BinaryTreeKthSmallest {

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr, int k) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr, k);

        // 遍历到第k个提前结束
        if (arr.size() == k) {
            return arr;
        }
        arr.add(root.val);
        inorder(root.right, arr, k);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>(), k);
        return nums.get(k - 1);
    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(4);
            TreeNode node4 = new TreeNode(3);
            TreeNode node5 = new TreeNode(6);
            root.right = node5;
            root.left = node4;
            node4.left = node2;
            node4.right = node3;
            node2.left = node1;

            BinaryTreeKthSmallest btk = new BinaryTreeKthSmallest();
            int result = btk.kthSmallest(root, 3);
            System.out.print(result);
    }
}
