package begin;

public class NumIslands {

    int result = 0;

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int l = grid[0].length;
        int[][] visit = new int[r][l];

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < l; y++) {
                if (grid[x][y] == '0') {
                    continue;
                }
                if (visit[x][y] == 1) {
                    continue;
                }
                result++;
                travel(grid, r, l, x, y, visit);
            }
        }

        return result;
    }

    private void travel(char[][] grid, int r, int l, int x, int y, int[][] visit) {
        if (x >= r || y >= l || x < 0 || y < 0) {
            return;
        }
        if (visit[x][y] == 1) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }

        visit[x][y] = 1;
        travel(grid, r, l, x+1, y, visit);
        travel(grid, r, l, x-1, y, visit);
        travel(grid, r, l, x, y+1, visit);
        travel(grid, r, l, x, y-1, visit);
    }
}
