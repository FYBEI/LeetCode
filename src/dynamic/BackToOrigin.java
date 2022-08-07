package dynamic;

public class BackToOrigin {

    public int backToOrigin(int n, int len){

        // dp[i][j] 表示从0出发走i步，到j点的方案数
        int[][] dp = new int[n+1][len];

        dp[0][0] = 1;
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < len; j++){
                dp[i][j] = dp[i-1][(j-1+len)%len] + dp[i-1][(j+1)%len];
            }
        }

        return dp[n][0];
    }
}
