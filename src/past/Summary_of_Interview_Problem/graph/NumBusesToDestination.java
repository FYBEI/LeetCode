package past.Summary_of_Interview_Problem.graph;

import java.util.*;

public class NumBusesToDestination {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        // 建图，公交路线为节点，拥有相同公交站的节点连一条边
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        // 公交站和线路之间的映射
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        // 动态规划思想，dis[i]表示从出发到线路i的步数，起始都为-1
        // 第一批添加进队列的dis = 1，之后添加进队列dis[y] = dis[x] + 1， 表示在前一路线上进行一次转乘
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        // 广度优先搜索，使用到队列，先将出发地的路线都添加进队列
        Queue<Integer> que = new LinkedList<Integer>();
        for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[bus] = 1;
            que.offer(bus);
        }
        // 获得队列顶的每一条路线，如果存在另一条路线y，两个路线在图中相连，且y还没有添加进队列，则将y添加进队列
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                // 这里dis[y] == -1，表示y还没有添加进队列过
                if (edge[x][y] && dis[y] == -1) {
                    // 表示当前路线在前一个路线的基础上进行一次转乘
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        // 获得可达终点站的所有路线，获取这些线路的最小换乘数
        int ret = Integer.MAX_VALUE;
        for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;

    }
}
