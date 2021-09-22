package dynamic;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n == 0){
            return m;
        }
        if (m == 0){
            return n;
        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j < m; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++){
            char c1 = word1.charAt(i-1);

            for (int j = 1; j <= m; j++){
                char c2 = word2.charAt(j-1);

                if (c1 == c2){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] - 1) + 1;
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[n][m];
    }
}
