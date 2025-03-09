package past.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    // 带标记位节点，在原节点的基础上增加了该节点的层数，该节点的位置
    class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    // 每层的宽度为 最后一个非空节点的位置 - 第一个非空节点的位置
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;

        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();

            // 如果节点非空，则可以获得其位置
            if (a.node != null) {

                // 添加子节点，子节点层数为当前节点层数+1，左节点位置为 pos*2，右节点位置为 pos*2 + 1
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));

                // 如果当前层数改变，则说明节点为该层第一个非空节点，计算其位置作为该层左边界
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                // 后续不断更新每层的宽度
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
}
