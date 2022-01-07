package dynamic;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {

                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else if (dp[i-1][j-1] == 0){
                        dp[i][j] = 1;
                    }else {
                        int tmp = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);

                        dp[i][j] = tmp+1;
                    }

                    if (dp[i][j] * dp[i][j] > max){
                        max = dp[i][j]*dp[i][j];
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();

        char[][] matrix = {{'1', '0', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int res = ms.maximalSquare(matrix);
        System.out.println(res);
    }
}
