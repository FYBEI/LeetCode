package past.dynamic;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;

        // left[i][j] 表示第i，j个元素左边连续1的数量
        int[][] left = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                // 宽度则为当前行的左边连续的1数量
                int width = left[i][j];
                int area = width;
                // 主键增加高度
                for (int k = i-1; k >= 0; k--) {
                    // 长方形宽度取决于最短的宽度
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i-k+1)*width);
                }
                ret = Math.max(ret, area);
            }
        }

        return ret;
    }
}
