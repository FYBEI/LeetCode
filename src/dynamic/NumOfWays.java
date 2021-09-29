package dynamic;

import java.util.*;

public class NumOfWays {
    static final int MOD = 1000000007;

    /**
     * 递推：f[i][type] 为网格大小为i*3，最后一行排列情况为type时的方案数。
     * f[i][type] 只受 f[i-1][type'] 影响， f[i][type] 等于所有 f[i-1][type'] 的和
     */
    public int numOfWays(int n) {
        // 预处理出所有满足条件的 type
        List<Integer> types = new ArrayList<Integer>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (i != j && j != k) {
                        // 只要相邻的颜色不相同就行
                        // 将其以十进制的形式存储
                        types.add(i * 9 + j * 3 + k);
                    }
                }
            }
        }
        int typeCnt = types.size();
        // 预处理出所有可以作为相邻行的 type 对
        int[][] related = new int[typeCnt][typeCnt];
        for (int i = 0; i < typeCnt; ++i) {
            // 得到 types[i] 三个位置的颜色
            int x1 = types.get(i) / 9, x2 = types.get(i) / 3 % 3, x3 = types.get(i) % 3;
            for (int j = 0; j < typeCnt; ++j) {
                // 得到 types[j] 三个位置的颜色
                int y1 = types.get(j) / 9, y2 = types.get(j) / 3 % 3, y3 = types.get(j) % 3;
                // 对应位置不同色，才能作为相邻的行
                if (x1 != y1 && x2 != y2 && x3 != y3) {
                    related[i][j] = 1;
                }
            }
        }
        // 递推数组
        int[][] f = new int[n + 1][typeCnt];
        // 边界情况，第一行可以使用任何 type
        for (int i = 0; i < typeCnt; ++i) {
            f[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < typeCnt; ++j) {
                for (int k = 0; k < typeCnt; ++k) {
                    // f[i][j] 等于所有 f[i - 1][k] 的和
                    // 其中 k 和 j 可以作为相邻的行
                    if (related[k][j] != 0) {
                        f[i][j] += f[i - 1][k];
                        f[i][j] %= MOD;
                    }
                }
            }
        }
        // 最终所有的 f[n][...] 之和即为答案
        int ans = 0;
        for (int i = 0; i < typeCnt; ++i) {
            ans += f[n][i];
            ans %= MOD;
        }
        return ans;
    }


    /**
     * 优化递推：一行一共有12种type，可以分为两类，ABC类6种和ABA类6种，用f[i][0]表示ABC类，f[i][1]表示ABA类
     * 第i-1行为ABC类，第i行为ABC类共2种方案，第i行为ABA类共2种方案
     * 第i-1行为ABA类，第i行为ABC类共2种方案，第i行为ABA类共3种方案
     *
     * 递推公式：f[i][0] = 2*f[i-1][0] + 2*f[i-1][1]
     *          f[i][1] = 2*f[i-1][0] + 3*f[i-1][1]
     */
    public int numOfWays2(int n) {
        long fi0 = 6, fi1 = 6;
        for (int i = 2; i <= n; ++i) {
            long newFi0 = (2 * fi0 + 2 * fi1) % MOD;
            long newFi1 = (2 * fi0 + 3 * fi1) % MOD;
            fi0 = newFi0;
            fi1 = newFi1;
        }
        return (int) ((fi0 + fi1) % MOD);
    }

}
