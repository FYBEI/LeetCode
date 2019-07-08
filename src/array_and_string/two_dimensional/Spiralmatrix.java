package array_and_string.two_dimensional;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Spiralmatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length <= 0){
            List<Integer> order = new ArrayList<>(0);
            return order;
        }

        List<Integer> order = new ArrayList<>();

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int length = rowNum*colNum;

       //设置四种方向，向上（col-1），向下（col+1），向左（row-1），向右（row+1）
        final int TO_U = 1;
        final int TO_D = 2;
        final int TO_L = 3;
        final int TO_R = 4;

        //设置四个边界，每次走到转弯时要缩小相应边界
        int left = 0;
        int up = 1;
        int right = colNum-1;
        int down = rowNum - 1;

        //起始向右，如果只有一列，就向下
        int direction = 0;
        if (colNum == 1){
            direction = TO_D;
        }else {
            direction = TO_R;
        }

        //转向的判段
        //向下后——>左转：到达下边界，row == down，缩小下边界down++
        //向上后——>右转：到达上边界，row == up，缩小上边界up--
        //向左后——>上转：到达左边界，col == left，缩小左边界left++
        //向右后——>下转，到达右边界，col == right，缩小右边界right--

        int row = 0;
        int col = 0;

        for (int i = 0; i < length; i++){
            order.add(matrix[row][col]);
            switch (direction){
                case TO_U:{
                    row--;
                    if (row == up){
                        up++;
                        direction = TO_R;
                    }
                    break;
                }
                case TO_D:{
                    row++;
                    if (row == down){
                        down--;
                        direction = TO_L;
                    }
                    break;
                }
                case TO_L:{
                    col--;
                    if (col == left){
                        left++;
                        direction = TO_U;
                    }
                    break;
                }
                case TO_R:{
                    col++;
                    if (col == right){
                        right--;
                        direction = TO_D;
                    }
                    break;
                }
            }

        }

        return order;
    }
}
