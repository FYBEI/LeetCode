package Summary_of_Interview_Problem.tree;

import java.util.Stack;

public class BinaryTreeKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        insert(root, stack, k);

        return stack.peek().val;
    }

    private void insert(TreeNode root, Stack<TreeNode> stack, int k){
        if (root.right != null){
            insert(root.right, stack, k);
        }

        if (stack.size() == k){
            return;
        }

        stack.push(root);

        if (root.left != null){
            insert(root.left, stack, k);
        }
    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(4);
            TreeNode node4 = new TreeNode(5);
            TreeNode node5 = new TreeNode(6);
            root.right = node1;
            root.left = node4;
            node1.left = node2;
            node4.right = node3;
            node4.left = node5;

            BinaryTreeKthSmallest btk = new BinaryTreeKthSmallest();
            int result = btk.kthSmallest(root, 4);
            System.out.print(result);
    }
}
