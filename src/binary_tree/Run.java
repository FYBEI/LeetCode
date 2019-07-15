package binary_tree;

import binary_tree.conclude.BuildTree;
import binary_tree.conclude.Codec;
import binary_tree.traversal.PostOrder;
import binary_tree.traversal.PreOrder;
import org.junit.Test;

import java.util.List;

public class Run {

    @Test
    public void buildTree(){
        BuildTree buildTree = new BuildTree();

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode tree = buildTree.buildTree(inorder, postorder);

        PreOrder preOrder = new PreOrder();

        List<Integer> list = preOrder.preorderTraversal(tree);

        list.stream().forEach(obj -> {
            System.out.print(obj + " ");
        });
    }

    @Test
    public void buildTree2(){
        BuildTree buildTree = new BuildTree();

        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};

        TreeNode tree = buildTree.buildTree2(preorder, inorder);

        PostOrder postOrder = new PostOrder();

        List<Integer> list = postOrder.postorderTraversal(tree);

        list.stream().forEach(obj -> {
            System.out.print(obj + " ");
        });
    }

    @Test
    public void code(){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);

        a1.setLeft(a2);
        a1.setRight(a3);
        a2.setLeft(a4);
        a3.setRight(a5);
        a3.setLeft(a6);

        Codec codec = new Codec();
        String result = codec.serialize(a1);
        System.out.println(result);


        TreeNode root = codec.deserialize(result);

        PreOrder preOrder = new PreOrder();
        List<Integer> list = preOrder.preorderTraversal(root);

        list.stream().forEach(obj -> {
            System.out.print(obj + " ");
        });
    }

}
