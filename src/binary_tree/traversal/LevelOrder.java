package binary_tree.traversal;

import binary_tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            List<TreeNode> level = new ArrayList<>();

            //取出一整行的结点
            while (!queue.isEmpty()){
                TreeNode tree = queue.remove();
                level.add(tree);
            }

            //将这一行的结点的子结点按顺序放入栈中
            for (TreeNode tree : level){
                if (tree.getLeft() != null){
                    queue.add(tree.getLeft());
                }
                if (tree.getRight() != null){
                    queue.add(tree.getRight());
                }
            }

            //将这行结点放入result中
            List<Integer> levelValue = level.stream().map(obj -> {
                return obj.getVal();
            }).collect(Collectors.toList());

            result.add(levelValue);
        }

        return result;
    }
}
