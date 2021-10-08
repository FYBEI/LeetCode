package binary_search_tree;

public class KthLargest {
    public int kthLargest(TreeNode root, int k) {

        int right = search(root.right);

        if (right == k-1){
            return root.val;
        }else if (right > k-1){
            return kthLargest(root.right, k);
        }else {
            return kthLargest(root.left, k-right-1);
        }
    }

    private int search(TreeNode root){
        if (root == null){
            return 0;
        }

        return 1 + search(root.left) + search(root.right);
    }
}
