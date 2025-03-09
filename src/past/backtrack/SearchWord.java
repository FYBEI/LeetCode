package past.backtrack;

public class SearchWord {
    boolean[][] vis;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){

                // 首字母相等，开始搜索
                if (board[i][j] == word.charAt(0)){
                    vis = new boolean[m][n];
                    // 搜索成功则返回true
                    if (search(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, int x, int y, String word, int i){
        // 当前位置的已经访问过了 or 当前位置的字符不同 就返回false
        if (vis[x][y] || word.charAt(i) != board[x][y]){
            return false;
        }

        // 如果字符串字符匹配完，则返回false
        if (i == word.length()-1){
            return true;
        }

        // 标记当前位置已经访问了
        vis[x][y] = true;

        // 向矩阵上下左右方向，匹配字符串下一个字符
        boolean up = false, down = false, left = false, right = false;
        if (x > 0){
            up = search(board, x-1, y, word, i+1);
        }
        if (x < board.length-1){
            down = search(board, x+1, y, word, i+1);
        }
        if (y > 0){
            left = search(board, x, y-1, word, i+1);
        }
        if (y < board[0].length-1){
            right = search(board, x, y+1, word, i+1);
        }

        // 回溯
        vis[x][y] = false;

        return up||down||left||right;
    }
}
