package begin;

import java.util.PriorityQueue;

public class TrapRainWater2 {

    // 最小堆保证了每次处理的是当前最低的“围墙”，因此可以确定其相邻点的接水量。
    // 通过动态更新“围墙”高度，确保了后续计算的正确性。
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        int[][] visited = new int[row][col];

        // 最小堆，存放矩阵边界
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {return a[2] - b[2];});

        for (int i = 0; i < row; i++) {
            priorityQueue.add(new int[]{i, 0, heightMap[i][0]});
            priorityQueue.add(new int[]{i, col-1, heightMap[i][col-1]});
            visited[i][0] = 1;
            visited[i][col-1] = 1;
        }
        for (int j = 1; j < col-1; j++) {
            priorityQueue.add(new int[]{0, j, heightMap[0][j]});
            priorityQueue.add(new int[]{row-1, j, heightMap[row-1][j]});
            visited[0][j] = 1;
            visited[row-1][j] = 1;
        }

        int res = 0;
        while (!priorityQueue.isEmpty()) {
            // 取出最小的边界
            int[] minIndex = priorityQueue.poll();
            // 比较相邻点
            res += trap(minIndex[0]-1, minIndex[1], row, col, minIndex[2], heightMap, visited, priorityQueue);
            res += trap(minIndex[0]+1, minIndex[1], row, col,minIndex[2], heightMap, visited, priorityQueue);
            res += trap(minIndex[0], minIndex[1]-1, row, col, minIndex[2], heightMap, visited, priorityQueue);
            res += trap(minIndex[0], minIndex[1]+1, row, col, minIndex[2], heightMap, visited, priorityQueue);
        }

        return res;
    }

    // 遍历四周的点
    private int trap(int i, int j, int row, int col, int minHeight, int[][] heightMap, int[][] visited, PriorityQueue<int[]> priorityQueue) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return 0;
        }
        if (visited[i][j] == 1){
            return 0;
        }

        visited[i][j] = 1;

        // 获取当前点的高度
        int height = heightMap[i][j];
        // 将当前点的高度更新为 max(原高度，当前围墙高度)
        // 添加到最小堆中，水可以填充当作围墙
        priorityQueue.add(new int[]{i, j, Math.max(minHeight, height)});
        // 如果当前点高度小于围墙，则可以接雨水
        if (height < minHeight) {
            return minHeight - height;
        }
        return 0;
    }
}
