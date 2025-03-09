package past.binary_tree;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node == null){
                sb.append("null");

                if (!queue.isEmpty()){
                    sb.append(",");
                }

            }else {
                sb.append(node.val);
                sb.append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        if (nodes.length == 1){
            if (nodes[0].equals("null")){
                return null;
            }else {
                TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
                return root;
            }
        }

        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        int i = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (i < nodes.length && !nodes[i].equals("null")){
                TreeNode left = new TreeNode(Integer.valueOf(nodes[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("null")){
                TreeNode right = new TreeNode(Integer.valueOf(nodes[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        String str = ser.serialize(root);
        System.out.println(str);

        TreeNode ans = deser.deserialize(str);
    }

}
