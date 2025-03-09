package past.dynamic;

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 起始位置就遇见障碍
        if (obstacleGrid[0][0] == 1){
            return 0;
        }

        int[][] dp = new int[m][n];
        // 初始化，起始位置为1，第一行和第一列中，遇见障碍之前的可达路线为1，遇见障碍后的可达路线为0
        dp[0][0] = 1;
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int j = 1; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
            }else {
                dp[0][j] = dp[0][j-1];
            }
        }

        // 状态转移，障碍物位置的可达路线为0，其余位置的可达路线为上一个点的路线数 + 前一个点的路线数
        // dp[i][j] = dp[i-1][j] + dp[i][j-1] or 0
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
