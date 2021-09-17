package queue_stack.queue;

public class MaxAreaOfIsland {
    int max;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        if (n == 0){
            return 0;
        }
        int m = grid[0].length;

        max = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < m; j ++){

                //获取根节点
                if (grid[i][j] == 1){

                    int area = dfs(grid, i, j);
                    if (max < area){
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    // 返回岛屿的面积
    private int dfs(int[][] grid, int i, int j){
        // 访问过就置0
        grid[i][j] = 0;

        int up = 0, down = 0, left = 0, right = 0;
        //如果未超界，且上下左右为岛屿，遍历上，下，左，右
        if (i > 0 && grid[i-1][j] == 1){
            up = dfs(grid, i - 1, j);
        }

        if (i < grid.length-1 && grid[i+1][j] == 1){
            down = dfs(grid, i + 1, j);
        }

        if (j > 0 && grid[i][j-1] == 1){
            left = dfs(grid, i, j - 1);
        }

        if (j < grid[0].length-1 && grid[i][j+1] == 1){
            right = dfs(grid, i, j + 1);
        }

        // 小岛面积 = 上 + 下 + 左 + 右 + 1
        int area = up + down + left + right + 1;

        return area;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1},
        };

        MaxAreaOfIsland mai = new MaxAreaOfIsland();
        int area = mai.maxAreaOfIsland(m);
        System.out.println(area);
    }
}
