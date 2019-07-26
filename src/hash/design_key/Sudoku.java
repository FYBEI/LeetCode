package hash.design_key;

import java.util.*;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */
public class Sudoku {

    /**
     * 使用hash表进行标记，可以进一步简化，将三层判断合三为一，只进行两层for循环
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        if (board.length < 9 || board[0].length < 9){
            return false;
        }

        //判断行
        boolean validrow = true;
        for (int i = 0; i < board.length; i++){
            validrow &= isValidRow(board[i]);
        }

        //判断列
        boolean validcol = true;
        for (int i = 0; i < board[0].length; i++){
            validcol &= isValidCol(i, board);
        }

        //判断九宫格
        boolean validnine = isValidNine(board);

        return validcol&&validnine&&validrow;
    }

    private boolean isValidRow(char[] board){
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board.length; i++){
            if (set.contains(board[i])){
                return false;
            }

            if (board[i] != '.'){
                set.add(board[i]);
            }
        }

        return true;
    }

    private boolean isValidCol(int col, char[][] board){
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board.length; i++){
            if (set.contains(board[i][col])){
                return false;
            }

            if (board[i][col] != '.'){
                set.add(board[i][col]);
            }
        }

        return true;
    }

    private boolean isValidNine(char[][] board){
        Map<Integer, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                int key = (i/3)*3 + j/3;
                if (!map.containsKey(key)){
                    map.put(key, new HashSet<>());
                }
                if (map.get(key).contains(board[i][j])){
                    return false;
                }else {
                    if (board[i][j] != '.'){
                        map.get(key).add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

    /**
     * 简化版
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        if (board.length < 9 || board[0].length < 9){
            return false;
        }

        Map<Integer, Set<Character>> nineMap = new HashMap<>();
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                //判断行
                if (rowSet.contains(board[i][j])){
                    return false;
                }

                if (board[i][j] != '.'){
                    rowSet.add(board[i][j]);
                }

                //判断九宫
                int key = (i/3)*3 + j/3;
                if (!nineMap.containsKey(key)){
                    nineMap.put(key, new HashSet<>());
                }
                if (nineMap.get(key).contains(board[i][j])){
                    return false;
                }else {
                    if (board[i][j] != '.'){
                        nineMap.get(key).add(board[i][j]);
                    }
                }
            }
            rowSet.clear();

            //判断列
            for (int j = 0; j < board[i].length; j++){
                if (colSet.contains(board[j][i])){
                    return false;
                }

                if (board[j][i] != '.'){
                    colSet.add(board[j][i]);
                }
            }
            colSet.clear();

        }

        return true;
    }

    /**
     * 使用数组进行标记判断
     * @param board
     * @return
     */
    public boolean isValidSudoku3(char[][] board) {
        int[][] rowNumCounts = new int[9][9];
        int[][] colNumCounts = new int[9][9];
        int[][] matrixNumCounts = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    rowNumCounts[i][num]++;
                    colNumCounts[j][num]++;
                    int matrixIndex = 3 * (i / 3) + j / 3;
                    matrixNumCounts[matrixIndex][num]++;
                    if (rowNumCounts[i][num] == 2
                            || colNumCounts[j][num] == 2
                            || matrixNumCounts[matrixIndex][num] == 2) {
                        return false;
                    }

                }
            }
        }
        return true;
    }
}
