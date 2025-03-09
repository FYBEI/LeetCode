package past.dynamic;

/**
 * 最短路径
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int len = grid.length;
        if (len == 0){
            return 0;
        }
        int wid = grid[0].length;
        if (wid == 0){
            return 0;
        }

        //tmp[i][j]表示第i,j个位置的最短路径
        int[][] tmp = new int[len][wid];
        tmp[0][0] = grid[0][0];

        //先填充两条边界的最短路径
        for (int i = 1; i < wid; i++){
            tmp[0][i] = grid[0][i] + tmp[0][i-1];
        }
        for (int i = 1; i < len; i++){
            tmp[i][0] = grid[i][0] + tmp[i-1][0];
        }

        for (int i = 1; i < len; i++){
            for (int j = 1; j < wid; j++){
                tmp[i][j] = Math.min(tmp[i-1][j] + grid[i][j], tmp[i][j-1] + grid[i][j]);
            }
        }

        return tmp[len-1][wid-1];
    }
}
