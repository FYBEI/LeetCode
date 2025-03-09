package past.random_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * 示例 1：
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 *
 * 示例 2：
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 */
public class LongestFibSubseq {

    /**
     * 定义状态
     * dp[i][j]表示以A[i]，A[j]结尾的最长斐波那契子序列长度。
     *
     * 转移方程
     * dp[i][j] = MAX(dp[k][i] + 1) 满足 k < i < j，且A[k] = A[j] - A[i]。
     */
    public int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;

        // 存储数字即对应位置
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 1; i < n; i++){
            index.put(arr[i], i);
        }

        // 存储最长距离
        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;

        // k代表第三个数，j代表第二个数，i代表第一个数
        for (int k = 0; k < n; ++k){
            for (int j = 0; j < k; ++j) {

                // 寻找arr[k]-arr[j]的位置，即斐波那契数列第一个数，否则返回-1
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                // 没有找到，或者第一个数位置反而在第二个数之后的就跳过
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    // i*n+j作为hash值，存储这种配对的最长距离，如果没有存储，则默认距离为2，即初始三个数
                    int cand = longest.getOrDefault(i * n + j, 2) + 1;
                    longest.put(j * n + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }
}
