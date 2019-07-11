package queue_stack.queue;

import java.util.*;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 ****************
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 ****************
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class NumInlands {

    private class Island{
        private int col;
        private int row;

        public Island(int row, int col) {
            this.col = col;
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null){
                return false;
            }
            if (this == obj){
                return true;
            }
            if (obj instanceof Island){
                Island island = (Island) obj;
                if (island.getRow() == row && island.getCol() == col){
                    return true;
                }
            }

            return false;
        }

        @Override
        public int hashCode(){
            return new Integer(col).hashCode() + new Integer(row).hashCode();
        }
    }
    /**
     * 利用BFS算法，根节点为从左至右，从上至下的第一个1
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int high = grid.length;

        if (high == 0){
            return 0;
        }
        int wide = grid[0].length;

        Queue<Island> queue = new LinkedList<>();
        Set<Island> used = new HashSet<>();
        int num = 0;

        Island root = null;
        for (int i = 0; i < high; i++){
            for (int j = 0; j < wide; j++){
                if (grid[i][j] == '1'){
                    //找到根节点
                    root = new Island(i, j);

                    //如果找的根节点已经包含再used中，说明非根结点
                    if (!used.contains(root)){

                        //将根节点加入队列和used
                        queue.add(root);
                        used.add(root);

                        //如果队列不空
                        while (!queue.isEmpty()){
                            Island island = queue.peek();

                            List<Island> neighbors = new ArrayList<>();
                            //获得该陆地四周的陆地
                            if (island.getRow() > 0 && grid[island.getRow()-1][island.getCol()] != '0'){
                                Island up = new Island(island.getRow()-1, island.getCol());
                                neighbors.add(up);
                            }
                            if (island.getRow() < high-1 && grid[island.getRow()+1][island.getCol()] != '0'){
                                Island down = new Island(island.getRow()+1, island.getCol());
                                neighbors.add(down);
                            }
                            if (island.getCol() > 0 && grid[island.getRow()][island.getCol()-1] != '0'){
                                Island left = new Island(island.getRow(), island.getCol()-1);
                                neighbors.add(left);
                            }
                            if (island.getCol() < wide-1 && grid[island.getRow()][island.getCol()+1] != '0'){
                                Island right = new Island(island.getRow(), island.getCol()+1);
                                neighbors.add(right);
                            }

                            //将四周的陆地加入队列
                            if (!neighbors.isEmpty()){
                                neighbors.stream().forEach(obj -> {
                                    if (!used.contains(obj)){
                                        queue.add(obj);
                                        used.add(obj);
                                    }

                                });
                            }

                            //移出队列头
                            Island remove = queue.remove();
                            grid[remove.getRow()][remove.getCol()] = '0';
                        }

                        num++;
                    }
                }
            }
        }


        return num;
    }


    /**
     * 使用dfs算法实现
     */
    public int numIslands2(char[][] grid) {
        int count = 0;
        if (grid.length == 0 ) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++){
            int m = grid[i].length;
            for (int j = 0; j < m; j ++){

                //获取根节点
                if (grid[i][j] == '1'){

                    //dfs遍历与根节点相连的结点，即同一个小岛上的结点，跳出递归就说明一个小岛已经遍历完成，数量+1
                    DFSFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFSFill(char[][] grid, int i, int j){
//        如果遇到小岛边界（即四周都为0，或不存在），就跳出递归
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';

        //遍历上，下，左，右，如果遍历过，就将1改为0
        DFSFill(grid, i - 1, j);
        DFSFill(grid, i + 1, j);
        DFSFill(grid, i, j - 1);
        DFSFill(grid, i, j + 1);
    }
}
