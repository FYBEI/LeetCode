package past.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序： [左] 根 [右]
 * 后续： [左] [右] 根
 */
public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr){
        if (pl > pr){
            return null;
        }

        // 根节点为后序遍历最后一个值
        int rootVal = postorder[pr];
        TreeNode root = new TreeNode(rootVal);

        // 定位根节点在中序遍历的位置
        int inorder_root = map.get(rootVal);

        // 得到右子树的节点数
        int rightNum = ir - inorder_root;

        root.left = buildTree(inorder, il, inorder_root-1, postorder, pl, pr-rightNum-1);
        root.right = buildTree(inorder, inorder_root+1, ir, postorder, pr-rightNum, pr-1);

        return root;
    }

    public static void main(String[] args) {
        BuildTree bt = new BuildTree();

        int[] inorder = {1,2,3};
        int[] postorder = {3,2,1};

        TreeNode root = bt.buildTree(inorder, postorder);

        System.out.println(root);
    }
}
