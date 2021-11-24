package backtrack;

public class Sudoku {

    boolean[][] col;
    boolean[][] row;
    boolean[][][] part;
    boolean over;

    public void solveSudoku(char[][] board) {
        // 标记列，行，九宫格中数字是否出现
        col = new boolean[9][9];
        row = new boolean[9][9];
        part = new boolean[3][3][9];
        over = false;

        // 初始化
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.') {
                    // 没有0，所以起始应该是1
                    int num = board[i][j] - '1';
                    col[j][num] = true;
                    row[i][num] = true;
                    part[i/3][j/3][num] = true;
                }
            }
        }

        // 使用回溯法逐行遍历
        backtrack(board, 0, 0);
    }

    private void backtrack(char[][] board, int i, int j) {
        // 标记完成填充
        if (i > 8 || j > 8){
            over = true;
            return;
        }

        if (board[i][j] == '.'){
            for (int x = 0; x <= 8; x++){

                // 已经使用过这个数字，则跳过
                if (col[j][x] || row[i][x] || part[i/3][j/3][x]){
                    continue;
                }else {
                    col[j][x] = true;
                    row[i][x] = true;
                    part[i/3][j/3][x] = true;
                    board[i][j] = (char) ('0' + x + 1);

                    // 进入下一列，或者下一行第一个
                    if (j < 8){
                        backtrack(board, i, j+1);
                    }else {
                        backtrack(board, i+1, 0);
                    }

                    // 如果已经完成填充，则不要回溯
                    if (over){
                        return;
                    }else {
                        col[j][x] = false;
                        row[i][x] = false;
                        part[i/3][j/3][x] = false;
                        board[i][j] = '.';
                    }

                }
            }
        }else {

            // 进入下一列，或者下一行第一个
            if (j < 8){
                backtrack(board, i, j+1);
            }else {
                backtrack(board, i+1, 0);
            }
        }

    }
}
