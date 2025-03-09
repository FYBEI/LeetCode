package past.Summary_of_Interview_Problem.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseTable2 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    int[] order;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        // 建立点间关系，当前点的后续点
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        order = new int[numCourses];
        index = numCourses-1;

        // 对图中每个点进行拓扑排序
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (valid){
            return order;
        }else {
            return new int[0];
        }
    }

    public void dfs(int u) {

        // 标记被访问的点为搜索中状态
        visited[u] = 1;
        // 遍历当前点的所有后序点
        for (int v: edges.get(u)) {

            // 如果后序点没有被访问过，深度遍历；如果为搜索中状态，说明出现环，valid标记为false
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }

        // 该点搜索完成
        visited[u] = 2;
        order[index--] = u;
    }

    public static void main(String[] args) {
        CourseTable2 ct = new CourseTable2();

        int numCourses = 5;
        int[][] pre = {{1,4}, {2,4}, {3,1}, {3,2}};

        int[] result = ct.findOrder(numCourses, pre);
        for (int i:result){
            System.out.print(i);
            System.out.print(' ');
        }
    }
}
