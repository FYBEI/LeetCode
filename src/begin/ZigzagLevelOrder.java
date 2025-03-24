package begin;

import java.util.*;

public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> levelVal = new ArrayList<>();
        levelVal.add(root.val);
        result.add(levelVal);
        levelVal = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Deque<TreeNode> nextLevel = new LinkedList<>();

        boolean r2l = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }

            if (queue.isEmpty()) {
                while (!nextLevel.isEmpty()) {
                    if (r2l) {
                        TreeNode node1 = nextLevel.pollLast();
                        levelVal.add(node1.val);
                        queue.addFirst(node1);
                    }else {
                        TreeNode node1 = nextLevel.pollFirst();
                        levelVal.add(node1.val);
                        queue.addLast(node1);
                    }
                }
                if (!levelVal.isEmpty()) {
                    result.add(levelVal);
                    levelVal = new ArrayList<>();
                }
                nextLevel = new LinkedList<>();
                r2l = !r2l;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        TreeNode node2 = new TreeNode(4);
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        node1.left = node3;
        TreeNode node4 = new TreeNode(3);
        node2.left = node4;
        TreeNode node5 = new TreeNode(-1);
        node2.right = node5;
        TreeNode node6 = new TreeNode(5);
        node3.left = node6;
        TreeNode node7 = new TreeNode(1);
        node3.right = node7;
        TreeNode node8 = new TreeNode(6);
        node4.right = node8;
        TreeNode node9 = new TreeNode(8);
        node5.right = node9;

        zigzagLevelOrder(root);
    }
}
