package dynamic;

public class NumRollsToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        final int MOD = 1000000000 + 7;

        // 骰子的最小数为d，最大数为d*f
        if (target < d) {
            return 0;
        }
        if (target == d){
            return 1;
        }
        if (target == f*d){
            return 1;
        }
        if (target > f*d){
            return 0;
        }

        // dp[i][j]表示i个面数为f的骰子，掷出j的总方法数
        int[][] dp = new int[d+1][target+1];

        // 初始化:
        // 当d == target时，dp[i][i] = 1  1<=i<=d
        for (int i = 1; i <= d; i++){
            dp[i][i] = 1;
        }
        // 当d == 1时，dp[1][j] = 1  j <= f
        for (int j = 1; j <= f && j <= target; j++){
            dp[1][j] = 1;
        }
        for (int i = 2; i <= d; i++){
            for (int j = i+1; j <= target; j++){

                // 超出范围
                if (j > i*f){
                    dp[i][j] = 0;
                }
                // i个骰子，target = k的方法数为：i-1个骰子，target = target - k 其中 1 <= k <= min(f,j) 的所有情况之和
                // dp[i][j] = ∑k = 1~min(f,j) （dp[i-1][j-k]）
                else {
                    for (int k = 1; k <= f && k <= j; k++){
                        dp[i][j] = (dp[i][j] + dp[i-1][j - k]) % MOD;
                    }
                }
            }
        }

        return dp[d][target];
    }

    public static void main(String[] args) {
        NumRollsToTarget nrtt = new NumRollsToTarget();

        int d = 3;
        int f = 6;
        int target = 9;

        int ans = nrtt.numRollsToTarget(d, f, target);
        System.out.println(ans);
    }
}
