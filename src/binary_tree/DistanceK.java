package binary_tree;

import java.util.*;

public class DistanceK {
    List<Integer> ans;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();

        // 获得距离其为k的节点
        getDis(root, target, k);

        return ans;
    }

    /**
     * 获得node孩子节点的中距离其为k的节点
     */
    private void getChild(TreeNode node, int k){
        if (node == null){
            return;
        }
        if (k == 0){
            ans.add(node.val);
            return;
        }
        getChild(node.left, k-1);
        getChild(node.right, k-1);
    }

    /**
     * 寻找target节点，并获得距离其为k的节点
     */
    private int getDis(TreeNode node, TreeNode target, int k){
        // 该分支未遇见target节点，返回1
        if (node == null){
            return -1;
        }
        // 找到target节点，先找target下的所有距离为k的子节点
        if (node.val == target.val){
            getChild(node, k);
            return 0;
        }

        int left = getDis(node.left, target, k);
        int right = getDis(node.right, target, k);
        // node与target的距离为其子节点中距离target的距离+1，如果node节点的子节点不包含target则返回-1
        int dis = -1;
        if (left != -1){
            dis = left + 1;
        }else if (right != -1){
            dis = right + 1;
        }else {
            return -1;
        }

        // 距离target为k的父节点，则添加；距离target小于k的节点，则在其另一个子节点寻找距离为k-dis-1的子节点
        if (dis == k){
            ans.add(node.val);
        }else if (dis < k){
            // 判断target在哪个分支下，则寻找另一个分支下距离为k-dis-1的子节点
            if (dis == left + 1){
                getChild(node.right, k-dis-1);
            }else {
                getChild(node.left, k-dis-1);
            }
        }

        return dis;
    }
}
