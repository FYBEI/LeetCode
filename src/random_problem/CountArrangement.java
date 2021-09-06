package random_problem;

import java.util.*;

/**
 * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
 *      - perm[i] 能够被 i 整除
 *      - i 能够被 perm[i] 整除
 * 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
 *  
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：
 * 第 1 个优美的排列是 [1,2]：
 *     - perm[1] = 1 能被 i = 1 整除
 *     - perm[2] = 2 能被 i = 2 整除
 * 第 2 个优美的排列是 [2,1]:
 *     - perm[1] = 2 能被 i = 1 整除
 *     - i = 2 能被 perm[2] = 1 整除
 */
public class CountArrangement {

    // match记录每一项可以匹配的数
    List<Integer>[] match;
    int num;
    // 记录已经使用过的数
    boolean[] vis;

    public int countArrangement(int n) {
        match = new List[n+1];
        vis = new boolean[n+1];

        for (int i = 0; i <= n; i++){
            match[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i%j==0 || j%i==0){
                    match[i].add(j);
                }
            }
        }

        backtrack(1, n);

        return num;
    }

    // 回溯法
    private void backtrack(int index, int n){

        // 当匹配到最后一项，则记录一次优美匹配
        if (index == n+1){
            num++;
            return;
        }

        // 依次遍历每一个未使用的匹配数，进入下一层匹配
        for (int x:match[index]){
            if (!vis[x]){
                vis[x] = true;
                backtrack(index+1, n);
                vis[x] = false;
            }
        }
    }
}
