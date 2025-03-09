package past.Summary_of_Interview_Problem.queue_stack;

/**
 * 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 *
 * 示例 2：
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int l = matrix[0][0];
        int r = matrix[n][n];

        while (l < r) {
            int mid = l + (r-l)/2;
            int count = countNoMoreThanMid(matrix, mid, n);

            // 如果小于中值的数的个数小于k，说明第k小的数大于中值，在中值右边；否则在中值左边
            if(count < k)
                l = mid+1;
            else
                r = mid;
        }
        return r;
    }

    /***
     * 计算矩阵中小于中值的个数
     * @param matrix 矩阵，不变
     * @param mid   中值，变化
     * @param n     矩阵范围，不变
     * @return
     */
    public int countNoMoreThanMid(int[][] matrix, int mid, int n) {
        int x = n, y = 0, count = 0;
        // x代表行，y代表列，从最底行，第一列开始

        while(x >= 0 && y <= n) {

            if(matrix[x][y] <= mid) {
                // 由于矩阵按升序排列，如果该行第一列的数小于中值，则这一整列的值都小于，数量为x+1
                count += x + 1;
                //下一列
                ++ y;
            }else {
                //如果首列数字大于中值，则换上一行
                -- x;
            }
        }
        return count;
    }
}
