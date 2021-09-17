package array_and_string.two_dimensional;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class SetZeros {
    // 标记访问过的点
    int[][] visit;

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        visit = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                // 已经访问过的直接跳过
                if (visit[i][j] == 1){
                    continue;
                }

                visit[i][j] = 1;
                if (matrix[i][j] == 0){
                    fillRow(i, matrix);
                    fillCol(j, matrix);
                }

            }
        }

    }

    // 填充行，标记所有填充过的点，避免重复填充
    private void fillRow(int row, int[][] matrix){
        for (int i = 0; i < matrix[row].length; i++){

            // 如果是未访问，且为0的，填充其列
            if (visit[row][i] == 0 && matrix[row][i] == 0){
                visit[row][i] = 1;
                fillCol(i, matrix);
            }
            matrix[row][i] = 0;
            visit[row][i] = 1;

        }
    }

    // 填充列，标记所有填充过的点，避免重复填充
    private void fillCol(int col, int[][] matrix){
        for (int i = 0; i < matrix.length; i++){

            // 如果是未访问，且为0的，填充其行
            if (visit[i][col] == 0 && matrix[i][col] == 0){
                visit[i][col] = 1;
                fillRow(i, matrix);
            }
            matrix[i][col] = 0;
            visit[i][col] = 1;

        }
    }

    private void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println('\n');
    }

    public static void main(String[] args) {
        SetZeros sz = new SetZeros();

        int[][] matrix = {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        };

        sz.setZeroes(matrix);
        sz.print(matrix);
    }
}
