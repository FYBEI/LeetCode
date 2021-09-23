package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = mirrorTree(right);
        root.right = mirrorTree(left);

        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int i = queue.size();

            for (int j = 0; j < i; j++){
                TreeNode node = queue.poll();

                TreeNode left = node.left;
                TreeNode right = node.right;

                node.left = right;
                node.right = left;

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return root;
    }
}
