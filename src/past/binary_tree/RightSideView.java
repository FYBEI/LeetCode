package past.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 层序遍历，从右往左方向
        while (!queue.isEmpty()){
            // 添加每一层最右边的节点
            ans.add(queue.peek().val);

            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                // 添加右子树，再添加左子树
                if (node.right != null){
                    queue.add(node.right);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
            }
        }

        return ans;
    }
}
