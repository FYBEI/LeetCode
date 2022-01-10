package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 若当前层的节点数不满，则认为是最后一层
        boolean end = false;
        while (!queue.isEmpty()) {

            int num = queue.size();
            for (int i = 0; i < num; i++){
                TreeNode node = queue.poll();

                // 如果已经被标记为最后一层，但是还有孩子节点，返回false
                if (end && node.left != null){
                    return false;
                }
                // 不存在左节点，但是存在右节点，返回false
                if (node.left == null && node.right != null){
                    return false;
                }
                // 左节点或者右节点为null，则标记为最后一层
                if (node.left == null || node.right == null){
                    end = true;
                }

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }

            }
        }

        return true;
    }
}
