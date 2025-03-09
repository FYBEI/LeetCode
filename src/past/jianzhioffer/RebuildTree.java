package past.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class RebuildTree {
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        if (len == 0) {
            return null;
        }else if (len == 1) {
            return new TreeNode(preorder[0]);
        }

        inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, len-1, inorder, 0, len-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root;
        }

        int rootIndex = inorderMap.get(root.val);
        int leftNum = rootIndex - inStart;

        root.left = build(preorder, preStart+1, preStart+leftNum, inorder, inStart, rootIndex-1);
        root.right = build(preorder, preStart+leftNum+1, preEnd, inorder, rootIndex+1, inEnd);

        return root;
    }
}
