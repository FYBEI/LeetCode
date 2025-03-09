package past.Summary_of_Interview_Problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 你将获得K个鸡蛋，并可以使用一栋从1到N共有 N层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层F ，满足0 <= F <= N 任何从高于 F的楼层落下的鸡蛋都会碎，从F楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层X扔下（满足1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 *
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 *
 * 示例 3：
 * 输入：K = 3, N = 14
 * 输出：4
 *
 *
 * 详细：https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution-2/
 */
public class EggDrop {

    /**
     * 传统动态规划，状态转移方程：E[i][j] = 1 + min{max(E[i-1][x-1], E[i][j-x])} 1<=x<=j
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop(int K, int N) {
        // E[i][j] 表示i个鸡蛋，j层楼最小需要多少次
        int[][] E = new int[K+1][N+1];

        for (int i = 1; i <= N; i++){
            E[1][i] = i;
        }

        for (int i = 2; i <= K; i++){
            for (int j = 1; j <= N; j++){
                int min = Integer.MAX_VALUE;

                for (int x = 1; x <= j; x++){
                    if (min > Math.max(E[i-1][x-1], E[i][j-x])){
                        min = Math.max(E[i-1][x-1], E[i][j-x]);
                    }
                }

                E[i][j] = 1 + min;
            }
        }

        return E[K][N];
    }

    /**
     * 二分法优化动态规划
     * @param K
     * @param N
     * @return
     */
    static Map<Integer, Integer> memo = new HashMap();

    public static int dp(int K, int N){
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0) {
                ans = 0;
            } else if (K == 1) {
                ans = N;
            } else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)), Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }

    public static int superEggDrop2(int K, int N) {
        return dp(K, N);
    }

    /**
     * 决策单调性
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop3(int K, int N){
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; ++i) {
            dp[i] = i;
        }

        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x - 1], dp2[n - x]) > Math.max(dp[x], dp2[n - x - 1])) {
                    x++;
                }

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]);
            }

            dp = dp2;
        }

        return dp[N];
    }

    /**
     * 数学法
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop4(int K, int N) {
        if (N == 1) {
            return 1;
        }
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= K; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int K = 9;
        int N = 10000;

        int result = superEggDrop2(K, N);

        System.out.println(result);
    }
}
