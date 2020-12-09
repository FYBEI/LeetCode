package HW.Greedy;

/**
 * 单源最短路径
 * Single-Source Shortest Path
 */
public class SSSP {

    static int max = Integer.MAX_VALUE;

    static void Dijkstra(int[][] graph, int v){
        int n = graph.length;

        // 记录原点到其他点的距离
        int[] dist = new int[n];
        // 存储最短路径
        int[] prev = new int[n];
        boolean[] s = new boolean[n];

        // 辅助数组初始化
        for (int i = 0; i < n; i++){
            //距离数组为图，源所在行
            dist[i] = graph[v][i];
            s[i] = false;
            // 如果原点到该点距离为无穷，则到该点无最短路径，标为0
            if (dist[i] == max){
                prev[i] = 0;
            }else {
                //有最短路径，标即为起始点
                prev[i] = v;
            }
        }

        // 起始点距离为0，且进入s集内
        dist[v] = 0;
        s[v] = true;

        for (int i = 0; i < n; i++){
            int tmp = max;

            int u = v;
            // v-s中找最小的dist[j]
            for (int j = 0; j < n; j++){
                if (!s[j] && dist[j] < tmp){
                    u = j;
                    tmp = dist[j];
                }
            }

            // 标记新加入的点
            s[u] = true;
            //修改v-s中的dist[j]
            for (int j = 0; j < n; j++){

                // 新加入的点，使到其他点的路径缩小
                if (!s[j] && graph[u][j] < max){
                    int newdist = dist[u] + graph[u][j];
                    if (newdist < dist[j]){
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++){
            System.out.println(dist[i]);
        }

    }

    public static void main(String[] args) {
        int v = 0;

        int[][] graph = {{max, max, 10, max, 30, 100},
                {max, max, 5, max, max, max},
                {max, max, max, 50, max, max},
                {max, max, max, max, max, 10},
                {max, max, max, 20, max, 60},
                {max, max, max, max, max, max}};

        Dijkstra(graph, v);
    }
}
