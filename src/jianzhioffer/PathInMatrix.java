package jianzhioffer;

public class PathInMatrix {

    int[][] visit;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visit[i][j] = 1;
                    if(searchPath(board, i, j, word, 0)) {
                        return true;
                    }
                    visit[i][j] = 0;
                }
            }
        }

        return false;
    }

    public boolean searchPath(char[][] board, int i, int j, String word, int k) {
        if (word.length()-1 == k) {
            return true;
        }

        boolean up, down, left, right;
        up = down = left = right = false;
        // 上
        if (i > 0 && visit[i-1][j] == 0 && board[i-1][j] == word.charAt(k+1)) {
            visit[i-1][j] = 1;
            up = searchPath(board, i-1, j, word, k+1);
            visit[i-1][j] = 0;
            if (up) {
                return up;
            }
        }
        // 下
        if (i < board.length-1 && visit[i+1][j] == 0 && board[i+1][j] == word.charAt(k+1)) {
            visit[i+1][j] = 1;
            down = searchPath(board, i+1, j, word, k+1);
            visit[i+1][j] = 0;
            if (down) {
                return down;
            }
        }
        // 左
        if (j > 0 && visit[i][j-1] == 0 && board[i][j-1] == word.charAt(k+1)) {
            visit[i][j-1] = 1;
            left = searchPath(board, i, j-1, word, k+1);
            visit[i][j-1] = 0;
            if (left) {
                return left;
            }
        }
        // 右
        if (j < board[0].length-1 && visit[i][j+1] == 0 && board[i][j+1] == word.charAt(k+1)) {
            visit[i][j+1] = 1;
            right = searchPath(board, i, j+1, word, k+1);
            visit[i][j+1] = 0;
            if (right) {
                return right;
            }
        }

        return up || down || left || right;
    }
}
