package begin;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 上下左右的边界
        int up = 0;
        int down = row-1;
        int left = 0;
        int right = col-1;

        // 右-1，下-2，左-3，上-4
        int dir = 1;
        // 当前位置
        int i = 0;
        int j = 0;

        List<Integer> res = new ArrayList<>();
        while (i >= up && i <= down && j >= left && j <= right) {
            res.add(matrix[i][j]);

            int nextI = 0;
            int nextJ = 0;
            switch (dir) {
                case 1:
                    // 往右的坐标
                    nextI = i;
                    nextJ = j+1;
                    // 超过右边界，改为向下，上边界+1
                    if (nextJ > right) {
                        up++;
                        nextI = i+1;
                        nextJ = j;
                        dir = 2;
                    }
                    break;
                case 2:
                    // 往下的坐标
                    nextI = i+1;
                    nextJ = j;
                    // 超过下边界，改为向左，右边界-1
                    if (nextI > down) {
                        right--;
                        nextI = i;
                        nextJ = j-1;
                        dir = 3;
                    }
                    break;
                case 3:
                    // 往左的坐标
                    nextI = i;
                    nextJ = j-1;
                    // 超过左边界，改为向上，下边界+1
                    if (nextJ < left) {
                        down--;
                        nextI = i-1;
                        nextJ = j;
                        dir = 4;
                    }
                    break;
                case 4:
                    // 往上的坐标
                    nextI = i-1;
                    nextJ = j;
                    // 超过上边界，改为向右，左边界+1
                    if (nextI < up) {
                        left++;
                        nextI = i;
                        nextJ = j+1;
                        dir = 1;
                    }
                    break;
            }
            i = nextI;
            j = nextJ;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
