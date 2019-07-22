package binary_search_tree;

import binary_search_tree.base_operate.Delete;
import binary_search_tree.base_operate.Insert;
import binary_search_tree.conclude.KthLargest;
import org.junit.Test;

public class Run {

    @Test
    public void iterator(){
        BSTIterator iterator = new BSTIterator(null);
        iterator.next();    // 返回 3
        iterator.next();    // 返回 7
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 9
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 15
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 20
        iterator.hasNext(); // 返回 false
    }

    @Test
    public void insert(){
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(3);

        a2.left = a4;
        a2.right = a5;
        a1.left = a2;
        a1.right = a3;

        Insert insert = new Insert();
        TreeNode node = insert.insertIntoBST(a1, 5);

    }

    @Test
    public void delete(){
        Delete delete = new Delete();

        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(7);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a6;

        TreeNode result = delete.deleteNode(a1, 3);

        out(result);
    }

    private void out(TreeNode root){
        if (root == null){
            return;
        }

        out(root.left);
        System.out.println(root.val);
        out(root.right);
    }

    @Test
    public void klargest(){
        int[] nums = {4,5,8,2};
        int k = 3;

        KthLargest kthLargest = new KthLargest(k, nums);

        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }
}
