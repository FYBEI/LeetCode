package past.backtrack;

public class TilingRectangle {
    int[][] dp;
    int ans;

    public int tilingRectangle(int n, int m) {
        if (n == m){
            return 1;
        }

        dp = new int[14][14];
        ans = 14*14;
        dfs(n, m, 0);

        return ans;
    }

    private void dfs(int n, int m, int cur) {
        if (cur > ans){
            return;
        }

        boolean full = true;
        int row = 0, col = 0;

        for (int i = 0; i < n && full; i++){
            for (int j = 0; j < m && full; j++){
                if (dp[i][j] == 0){
                    full = false;
                    row = i;
                    col = j;
                }
            }
        }

        if (full){
            ans = Math.min(ans, cur);
            return;
        }

        for (int len = Math.min(n - row, m-col); len >= 1; len--){
            boolean isEmpty = true;

            for (int i = row; i < row + len && isEmpty; i++){
                for (int j =col; j < col + len && isEmpty; j++){
                    if (dp[i][j] == 1) {
                        isEmpty = false;
                    }
                }
            }

            if (!isEmpty){
                continue;
            }

            for (int i = row; i < row + len; i++){
                for (int j = col; j < col + len; j++){
                    dp[i][j] = 1;
                }
            }

            dfs(n, m, cur+1);
            for (int i = row; i < row + len; i++){
                for (int j = col; j < col + len; j++){
                    dp[i][j] = 0;
                }
            }
        }
    }
}
