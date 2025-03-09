package past.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    /**
     * BFS + LevelOrder
     */
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            // 取每一层的最左边的值
            ans = queue.peek().val;

            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return ans;
    }

    /**
     * DFS
     */
    private int value;
    private int maxDeep;

    public int findBottomLeftValue2(TreeNode root) {
        maxDeep = 0;
        value = 0;

        DFS(root, 1);
        return value;
    }

    private void DFS(TreeNode root, int deep){
        if (root == null){
            return;
        }

        // 当前节点没有孩子节点，且当前节点超过最大深度，则更新value和maxDeep（处于同一深度的右子树就不会更新）
        if (root.left == null && root.right == null){
            if (deep > maxDeep){
                maxDeep = deep;
                value = root.val;
            }
        }

        // 先遍历左子树，后遍历右子树
        DFS(root.left, deep + 1);
        DFS(root.right, deep + 1);
    }

}
