package jianzhioffer;

import java.util.*;

public class CodeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add("null");
                }else {
                    list.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int n = strs.length;

        if (n == 1) {
            if (strs[0].equals("null")) {
                return null;
            }else {
                return new TreeNode(Integer.valueOf(strs[0]));
            }
        }

        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            if (i >= n) {
                break;
            }

            TreeNode node = queue.poll();
            if (!strs[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(strs[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (!strs[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(strs[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }
}
