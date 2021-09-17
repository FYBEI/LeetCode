package queue_stack.queue;

public class MaxAreaOfIsland {
    int max;
    int[][] visit;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        if (grid.length == 0){
            return 0;
        }
        int m = grid[0].length;

        visit = new int[n][m];
        max = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){

                // 访问过的节点就跳过
                if (visit[i][j] == 1){
                    continue;
                }

                //获取根节点
                if (grid[i][j] == 1){

                    visit[i][j] = 1;
                    int area = dfs(grid, i, j);

                    // 更新最大面积
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

        int up = 0, down = 0, left = 0, right = 0;
        //如果为超界，且上下左右未访问，且为陆地，则遍历上，下，左，右
        if (i > 0 && visit[i-1][j] == 0 && grid[i-1][j] == 1){
            visit[i-1][j] = 1;
            up = dfs(grid, i - 1, j);
        }

        if (i < grid.length-1 && visit[i+1][j] == 0 && grid[i+1][j] == 1){
            visit[i+1][j] = 1;
            down = dfs(grid, i + 1, j);
        }

        if (j > 0 && visit[i][j-1] == 0 && grid[i][j-1] == 1){
            visit[i][j-1] = 1;
            left = dfs(grid, i, j - 1);
        }

        if (j < grid[0].length-1 && visit[i][j+1] == 0 && grid[i][j+1] == 1){
            visit[i][j+1] = 1;
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
