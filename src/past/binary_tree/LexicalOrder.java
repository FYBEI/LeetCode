package past.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照构建字典树的方法进行深度遍历.
 * 字典树的节点内容，字典树节点包含val和children，children为一个节点数组，最大数量为10，因为本题中数字范围0~9
 * 设节点值为val，则其孩子节点值为 val*10 + i 其中 0 <= i <= 9
 * 注意，初始字典树从0开始构建，孩子范围为 1 ~ 9，最后要舍弃 0
 *
 * 在实际构建中，我们不需要真的创建树节点，而是按照构建字典树的思路，进行深度遍历，将值依次插入数组即可
 */

public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        // 起始值从0开始
        buildTree(0, n, ans);

        return ans;
    }

    private void buildTree(int val, int n, List<Integer> ans){

        // 当前节点值为0时，i的范围从1~9，当前节点值为1时，i的范围从0~9
        int i = val == 0 ? 1 : 0;

        for ( ; i <= 9; i++){
            int nextVal = val*10 + i;
            // 如果下一个节点的值超出范围，停止向下遍历
            if (nextVal > n){
                return;
            }

            ans.add(nextVal);
            buildTree(nextVal, n, ans);
        }
    }

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        int n = 13;

        List<Integer> ans = lexicalOrder.lexicalOrder(n);
        System.out.println(ans);
    }
}
