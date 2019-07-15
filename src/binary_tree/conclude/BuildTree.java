package binary_tree.conclude;

import binary_tree.TreeNode;

public class BuildTree {
    int index = 0;

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;

        if (length == 0){
            return null;
        }

        index = length-1;

        return getChild(inorder, postorder);
    }

    //后续遍历的最后一位是根节点
    //中序遍历，在根节点之前的是左子树，根节点之后的是右子树
    //获得中序遍历中根节点的位置
    private TreeNode getChild(int[] childTree, int[] postorder){
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);

        index--;

        int i = 0;
        for (; i < childTree.length; i++){
            if (childTree[i] == rootVal){
                break;
            }
        }

        //含有右子树
        if (i != childTree.length - 1){
            int x = i+1;
            int[] rightTree = new int[childTree.length-x];
            for (int j = 0; x < childTree.length; x++,j++){
                rightTree[j] = childTree[x];
            }

            TreeNode right = getChild(rightTree, postorder);
            root.setRight(right);
        }

        //含有左子树
        if (i != 0){
            int[] leftTree = new int[i];
            for (int j = 0; j < i; j++){
                leftTree[j] = childTree[j];
            }

            TreeNode left = getChild(leftTree, postorder);
            root.setLeft(left);
        }

        return root;
    }

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int length = inorder.length;

        if (length == 0){
            return null;
        }

        index = 0;

        return getChild2(inorder, preorder);
    }

    private TreeNode getChild2(int[] childTree, int[] preorder){
        int rootVal = preorder[index];
        TreeNode root = new TreeNode(rootVal);

        index++;

        int i = 0;
        for (; i < childTree.length; i++){
            if (childTree[i] == rootVal){
                break;
            }
        }

        //含有左子树
        if (i != 0){
            int[] leftTree = new int[i];
            for (int j = 0; j < i; j++){
                leftTree[j] = childTree[j];
            }

            TreeNode left = getChild2(leftTree, preorder);
            root.setLeft(left);
        }

        //含有右子树
        if (i != childTree.length - 1){
            int x = i+1;
            int[] rightTree = new int[childTree.length-x];
            for (int j = 0; x < childTree.length; x++,j++){
                rightTree[j] = childTree[x];
            }

            TreeNode right = getChild2(rightTree, preorder);
            root.setRight(right);
        }

        return root;
    }
}
