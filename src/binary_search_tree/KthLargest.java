package binary_search_tree;

import java.util.*;

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

    private List<Integer> inorder(TreeNode root, List<Integer> order, int k) {
        if (root == null){
            return order;
        }

        inorder(root.right, order, k);
        if (order.size() == k){
            return order;
        }
        order.add(root.val);

        inorder(root.left, order, k);
        return order;
    }
}
