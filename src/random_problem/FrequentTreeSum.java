package random_problem;

import Summary_of_Interview_Problem.tree.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 */
public class FrequentTreeSum {
    // key为treeSum，value为该treeSum出现次数
    Map<Integer, Integer> count = new HashMap<>();
    // 记录出现的最大次数
    int maxCount = 0;
    // 存储出现最大次数的treeSum
    List<Integer> maxlist = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null){
            return new int[0];
        }

        treeSum(root);

        int[] result = new int[maxlist.size()];
        for (int i = 0; i < maxlist.size(); i++){
            result[i] = maxlist.get(i);
        }

        return result;
    }

    private int treeSum(TreeNode node){
        int sum = node.val;

        if (node.left != null){
            sum += treeSum(node.left);
        }
        if (node.right != null){
            sum += treeSum(node.right);
        }

        // 更新计数器，最大次数，最大次数队列
        if (!count.containsKey(sum)){
            count.put(sum, 1);
            // 如果最大次数<=1，说明出现1次即最大
            if (maxCount <= 1){
                maxlist.add(sum);
            }
        }else {
            count.replace(sum, count.get(sum), count.get(sum)+1);
            // 如果当前treeSum的次数等于最大次数，添加进最大次数队列
            if (count.get(sum) == maxCount){
                maxlist.add(sum);
            } // 如果当前treeSum的次数大于最大次数，建立新的队列存储，更新最大次数
            else if (count.get(sum) > maxCount){
                maxCount = count.get(sum);
                maxlist = new ArrayList<>();
                maxlist.add(sum);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        FrequentTreeSum frequentTreeSum = new FrequentTreeSum();

        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(-5);
        root.left = new TreeNode(2);

        int[] result = frequentTreeSum.findFrequentTreeSum(root);
        for (int i:result){
            System.out.println(i);
        }
    }

}
