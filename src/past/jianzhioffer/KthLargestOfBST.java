package past.jianzhioffer;

public class KthLargestOfBST {

    public int kthLargest(TreeNode root, int k) {
        int right = countNum(root.right);
        if (right == k-1) {
            return root.val;
        }else if (right > k-1) {
            return kthLargest(root.right, k);
        }else {
            return kthLargest(root.left, k-right-1);
        }

    }

    public int countNum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countNum(root.left) + countNum(root.right) + 1;
    }
}
