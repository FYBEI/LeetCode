package past.queue_stack.queue;

public class SurroundArea {
    int[][] visit;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if (m == 1 || n == 1){
            return;
        }

        visit = new int[m][n];

        // 标记四条边界相邻的O
        for (int i = 0; i < m; i++){
            if (visit[i][0] == 0){
                dfs(board, i, 0);
            }
            if (visit[i][n-1] == 0){
                dfs(board, i, n-1);
            }
        }
        for (int j = 0; j < n; j++){
            if (visit[0][j] == 0){
                dfs(board, 0, j);
            }
            if (visit[m-1][j] == 0){
                dfs(board, m-1, j);
            }
        }

        // 将没有访问过的地方，全部改为x
        for (int i = 1; i < m-1; i++){
            for (int j = 1; j < n-1; j++){
                if (visit[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visit[i][j] == 1) {
            return;
        }
        visit[i][j] = 1;

        if (board[i][j] == 'X'){
            return;
        }

        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
