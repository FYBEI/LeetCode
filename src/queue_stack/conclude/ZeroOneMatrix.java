package queue_stack.conclude;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 */
public class ZeroOneMatrix {

    /**
     * 使用动态规划实现（还可以使用bfs）
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {

        int high = matrix.length;
        if (high == 0){
            return matrix;
        }
        int width = matrix[0].length;

        for (int i = 0; i < high; i++){
            for (int j = 0; j < width; j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = width + high;
                }

                if (i > 0){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i-1][j]+1);
                }
                if (j > 0){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j-1]+1);
                }
            }
        }

        for (int i = high-1; i >= 0; i--){
            for (int j = width-1; j >= 0; j--){
                if (i < high-1){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i+1][j]+1);
                }
                if (j < width-1){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j+1]+1);
                }

            }
        }


        return matrix;
    }
}
