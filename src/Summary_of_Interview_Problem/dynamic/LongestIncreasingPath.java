package Summary_of_Interview_Problem.dynamic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 */
public class LongestIncreasingPath {

    // 表示上下左右方向
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        rows = matrix.length;
        columns = matrix[0].length;
        // 动态规划，保存每个点的出度，即一个点的与其相邻的数字更大的点的数量，即有多少队列从该点出发
        // 边界条件，该点的值比周位点的值都要大
        int[][] outdegrees = new int[rows][columns];
        // 初始化outdegrees
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {

                // 遍历四个方向
                for (int[] dir : dirs) {
                    int newRow = i + dir[0], newColumn = j + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
                        ++outdegrees[i][j];
                    }
                }
            }
        }

        // BFS队列
        Queue<int[]> queue = new LinkedList<int[]>();
        // 先将所有出度为0的点存入队列
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (outdegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 根据出度数量从0开始排列为多层
        // 先从第0层遍历，更新其余单元格
        // 再将出度变为0的单元格加入下一层搜索
        // 当搜索结束时，搜索的总层数为最长递增路径的长度
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newColumn = column + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
                        --outdegrees[newRow][newColumn];
                        if (outdegrees[newRow][newColumn] == 0) {
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}};

        LongestIncreasingPath lip = new LongestIncreasingPath();
        int path = lip.longestIncreasingPath(matrix);
        System.out.print(path);
    }
}


/**
 * DFS版
 */
class Solution {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;

        // 记录以该点出发的路径最大长度
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {

        // 如果该点已经走过，直接返回
        if (memo[row][column] != 0) {
            return memo[row][column];
        }

        // 记录该点已经走过
        ++memo[row][column];
        // 遍历四个方向
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            // 如果存在值比当前点大的方向，则朝该方向深度遍历，更新该点最长路径
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}

