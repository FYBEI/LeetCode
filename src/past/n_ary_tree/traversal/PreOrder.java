package past.n_ary_tree.traversal;

import past.n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class PreOrder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        visit(root, list);
        return list;
    }

    private void visit(Node root, List<Integer> list){

        list.add(root.val);

        if (root.children != null && root.children.size() != 0){
            for (Node child : root.children){
                visit(child, list);
            }
        }
    }
}
