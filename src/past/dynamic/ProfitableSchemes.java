package past.dynamic;

public class ProfitableSchemes {
    public static final int MOD = 1000000000 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int m = group.length;

        // dp[i][j][k] 表示 前i个工作选择了j个员工，并且满足利润至少为k的计划总数目
        int[][][] dp = new int[m+1][n+1][minProfit+1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= m; i++){
            // 当前任务所需人，所获利润
            int member = group[i-1];
            int earn = profit[i-1];

            for (int j = 1; j <= n; j++){
                for (int k = 1; k <= minProfit; k++){
                    // 无法完成当前任务
                    if (j < member){
                        dp[i][j][k] = dp[i-1][j][k];
                    }else {
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-member][Math.max(0, k-earn)]) % MOD;
                    }
                }
            }
        }

        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[m][j][minProfit]) % MOD;
        }
        return sum;
    }

    // 数组降维
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int)1e9 + 7;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }


    public static void main(String[] args) {
        ProfitableSchemes ps = new ProfitableSchemes();

        int n = 100;
        int minProfit = 100;
        int[] group = {2,5,36,2,5,5,14,1,12,1,14,15,1,1,27,13,6,59,6,1,7,1,2,7,6,1,6,1,3,1,2,11,3,39,21,20,1,27,26,22,11,17,3,2,4,5,6,18,4,14,1,1,1,3,12,9,7,3,16,5,1,19,4,8,6,3,2,7,3,5,12,6,15,2,11,12,12,21,5,1,13,2,29,38,10,17,1,14,1,62,7,1,14,6,4,16,6,4,32,48};
        int[] profit = {21,4,9,12,5,8,8,5,14,18,43,24,3,0,20,9,0,24,4,0,0,7,3,13,6,5,19,6,3,14,9,5,5,6,4,7,20,2,13,0,1,19,4,0,11,9,6,15,15,7,1,25,17,4,4,3,43,46,82,15,12,4,1,8,24,3,15,3,6,3,0,8,10,8,10,1,21,13,10,28,11,27,17,1,13,10,11,4,36,26,4,2,2,2,10,0,11,5,22,6};

        int num = ps.profitableSchemes(n, minProfit, group, profit);
        System.out.println(num);
    }
}
