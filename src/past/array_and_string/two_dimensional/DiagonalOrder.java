package past.array_and_string.two_dimensional;

/**
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length <= 0){
            int[] order = new int[0];
            return order;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int length = rowNum*colNum;
        int[] order = new int[length];

        int row = 0;
        int col = 0;

        //设置四种方向，向右（col+1），向下(row+1)，左下(row+1,col-1)，右上(row-1,col+1)
        final int TO_R = 1;
        final int TO_D = 2;
        final int TO_LD = 3;
        final int TO_RU = 4;

        //起始方向是向右一个，接着变左下
        //如果只有一列，就向下一个，接着左上
        int direction = 0;
        if (colNum == 1){
            direction = TO_D;
        }else {
            direction = TO_R;
        }


        //向右条件：左下或者右上后 row = rowNum-1 or row = 0 && col < colNum-1
        //向下条件：左下或者右上后 col = 0 or col = colNum-1 && row < rowNum-1
        //向左下条件：右或者下后 row < rowNum-1 && col > 0
        //向右上条件：右或者下后 row > 0 && col < colNum-1

        for (int i = 0; i < length; i++){
            order[i] = matrix[row][col];
            switch (direction){
                case TO_R:{
                    col++;
                    if (row < rowNum-1 && col > 0){
                        direction = TO_LD;
                    }else if (row > 0 && col < colNum-1){
                        direction = TO_RU;
                    }
                    break;
                }
                case TO_D:{
                    row++;
                    if (row < rowNum-1 && col > 0){
                        direction = TO_LD;
                    }else if (row > 0 && col < colNum-1){
                        direction = TO_RU;
                    }
                    break;
                }
                case TO_LD:{
                    row++;
                    col--;
                    if (row == rowNum-1 && col < colNum-1){
                        direction = TO_R;
                    }else if (col == 0 && row < rowNum-1){
                        direction = TO_D;
                    }
                    break;
                }
                case TO_RU:{
                    row--;
                    col++;
                    if (row == 0 && col < colNum-1){
                        direction = TO_R;
                    }else if (col == colNum-1 && row < rowNum-1){
                        direction = TO_D;
                    }
                    break;
                }
            }
        }

        return order;
    }
}
