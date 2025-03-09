package past.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序： [左] 根 [右]
 * 前序： 根 [左] [右]
 */
public class BuildTree2 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0){
            return null;
        }

        for (int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, n-1, preorder, 0, n-1);
    }

    private TreeNode buildTree(int[] inorder, int il, int ir, int[] preorder, int pl, int pr) {
        if (pl > pr){
            return null;
        }

        // 根节点的值为前序遍历第一位
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        // 获得根节点位于中序遍历的位置
        int index = map.get(rootVal);

        // 获得左节点个数
        int left_num = index - il;
        root.left = buildTree(inorder, il, index-1, preorder, pl+1, pl+left_num);
        root.right = buildTree(inorder, index+1, ir, preorder, pl+left_num+1, pr);

        return root;
    }
}
