package Summary_of_Interview_Problem;

/**
 * 编写一个高效的算法来搜索 mxn 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 */
public class SearchMatrix {

    /**
     * 稍作修改的遍历
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;

        for (int j = 0; j < matrix[0].length; j++){
            for (int i = 0; i < m; i++){
                if (matrix[i][j] == target){
                    return true;
                }else if (matrix[i][j] > target){
                    m = i;
                }
            }

        }

        return false;
    }

    /**
     * 搜索空间缩小
     * @param matrix
     * @param target
     * @param up
     * @param down
     * @param left
     * @param right
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target, int up, int down, int left, int right){
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // 不符合条件直接跳出
        if (up > down || left > right){
            return false;
        }else if (target < matrix[up][left] || target > matrix[down][right]){
            return false;
        }

        int mid = left + (right - left)/2;
        int row = up;

        //遍历每一行的中间值
        while (row <= down && matrix[row][mid] <= target){
            if (matrix[row][mid] == target){
                return true;
            }
            row++;
        }

        // 前一个：搜索左下部分，后一个：搜索右上部分
        return searchMatrix(matrix, target, row, down, left, mid-1) || searchMatrix(matrix, target, up, row-1, mid+1, right);
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{-3, -1}};
        int target = -1;

        boolean result = searchMatrix(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
        System.out.println(result);
    }
}
