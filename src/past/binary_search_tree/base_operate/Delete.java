package past.binary_search_tree.base_operate;

import past.binary_search_tree.TreeNode;

public class Delete {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (key < root.val){
            root.left = deleteNode(root.left, key);
        }

        if (key > root.val){
            root.right = deleteNode(root.right, key);
        }

        if (key == root.val){

            //没有子节点
            if (root.left == null){
                return root.right;
            }

            if (root.right == null){
                return root.left;
            }


            TreeNode next = root.right;

            while (next.left != null){
                next = next.left;
            }

            next.left = root.left;
            return root.right;

        }

        return root;
    }
}
