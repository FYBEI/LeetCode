package past.dynamic;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = 1;
        for (int i = 0; i < n-1; i++){
            dp[m-1][i] = 1;
        }

        for (int i = 0; i < m-1; i++){
            dp[i][n-1] = 1;
        }

        for (int i = m-2; i >= 0; i--){
            for (int j = n-2; j >= 0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();

        int result = up.uniquePaths(3, 7);
        System.out.println(result);
    }
}
