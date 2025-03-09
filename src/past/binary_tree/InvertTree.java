package past.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree_BFS(TreeNode root) {
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int n = queue.size();

            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();

                TreeNode left = node.left;
                if(left != null){
                    queue.add(left);
                }
                TreeNode right = node.right;
                if (right != null){
                    queue.add(right);
                }

                node.left = right;
                node.right = left;
            }
        }

        return root;
    }

    public TreeNode invertTree_DFS(TreeNode root){
        if (root == null){
            return null;
        }

        return dfs(root);
    }

    private TreeNode dfs(TreeNode node){
        if (node == null || (node.left == null && node.right == null)){
            return node;
        }

        if(node.left == null){
            node.left = dfs(node.right);
            node.right = null;
        }else if (node.right == null){
            node.right = dfs(node.left);
            node.left = null;
        }else {
            TreeNode left = new TreeNode(node.left.val);
            left.left = node.left.left;
            left.right = node.left.right;

            node.left = dfs(node.right);
            node.right = dfs(left);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        InvertTree it = new InvertTree();
        it.invertTree_BFS(root);
    }
}
