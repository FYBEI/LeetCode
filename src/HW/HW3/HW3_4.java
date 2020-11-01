package HW.HW3;

import java.util.*;

public class HW3_4 {

    public static TreeNode getHuffmanTree(int[] p){
        TreeNode parent = null;
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (int value : p) {
            treeNodeList.add(new TreeNode(value));
        }

        while (treeNodeList.size() > 1){
            //现有子树排序
            Collections.sort(treeNodeList);

            TreeNode left = treeNodeList.get(0);
            TreeNode right = treeNodeList.get(1);

            parent = new TreeNode(left.getVal() + right.getVal());
            parent.setRight(right);
            parent.setLeft(left);

            // 移除旧的子树
            treeNodeList.remove(left);
            treeNodeList.remove(right);

            //添加新的子树
            treeNodeList.add(parent);
        }

        //返回根节点
        return parent;
    }

    public static void main(String[] args) {
        int[] p = {31, 12, 5, 2, 10, 18, 22};

        TreeNode root = HW3_4.getHuffmanTree(p);
        root.preOrder();
    }
}
