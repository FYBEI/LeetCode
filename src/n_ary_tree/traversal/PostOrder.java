package n_ary_tree.traversal;

import n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class PostOrder {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        visit(root, list);
        return list;
    }

    private void visit(Node root, List<Integer> list){
        if (root.children != null && !root.children.isEmpty()){
            for (Node child : root.children){
                visit(child, list);
            }
        }

        list.add(root.val);
    }
}
