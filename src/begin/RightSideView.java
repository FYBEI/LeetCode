package begin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);

        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> level = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                level.add(node.left);
            }
            if (node.right != null) {
                level.add(node.right);
            }
            if (queue.isEmpty() && !level.isEmpty()) {
                TreeNode right = level.get(level.size()-1);
                res.add(right.val);
                queue.addAll(level);
                level = new ArrayList<>();
            }
        }

        return res;
    }
}
