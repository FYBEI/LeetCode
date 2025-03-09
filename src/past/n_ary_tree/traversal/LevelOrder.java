package past.n_ary_tree.traversal;

import past.n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        List<Node> base = new ArrayList<>();
        base.add(root);
        visit(base, list);

        return list;
    }

    private void visit(List<Node> nodes, List<List<Integer>> list){
        List<Integer> val = new ArrayList<>();

        for (Node node : nodes){
            val.add(node.val);
        }

        list.add(val);

        List<Node> children = new ArrayList<>();
        for (Node node : nodes){
            if (node.children != null && !node.children.isEmpty()){
                children.addAll(node.children);
            }
        }

        if (!children.isEmpty()){
            visit(children, list);
        }
    }
}
