package past.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 */
public class BSTIterator {

    private TreeNode root;
    private Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        if (root != null){
            visit(root, queue);
        }
    }

    private void visit(TreeNode root, Queue<TreeNode> queue){
        if (root.left != null){
            visit(root.left, queue);
        }

        queue.add(root);

        if (root.right != null){
            visit(root.right, queue);
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (queue.isEmpty()){
            return 0;
        }

        return queue.poll().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.isEmpty()){
            return false;
        }

        return true;
    }
}
