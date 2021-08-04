package Summary_of_Interview_Problem.math;

import java.util.*;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 */
public class CountPrime {
    public int countPrimes(int n) {

        // 标记质数
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;

        for (int i = 2; i < n; ++i) {

            // 如果是质数，则ans+1，且对于该质数的所有倍数都标记为合数
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

}
