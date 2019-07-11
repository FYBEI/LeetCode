package queue_stack.stack;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            TreeNode cur = stack.peek();

            TreeNode left = cur.left;
            TreeNode right = cur.right;

            //如果该结点没有访问过
            if (!visited.contains(cur)){

                //如果不存在左节点，就添加当前结点,当前结点出栈
                //如果存在左节点且左节点没被访问过，就将左节点加入栈中
                if (left != null && !visited.contains(left)){
                    stack.push(left);
                    continue;
                }else {
                    visited.add(cur);
                    result.add(cur.val);
                    stack.pop();
                }
            }

            //如果右节点存在，就将右结点加入栈中
            if (right != null){
                stack.push(right);
            }
        }

        return result;
    }
}
