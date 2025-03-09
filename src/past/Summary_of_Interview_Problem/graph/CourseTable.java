package past.Summary_of_Interview_Problem.graph;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class CourseTable {
    /**
     * 判断图是否存在拓扑排序
     */

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        // 建立点间关系，当前点的后续点
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        // 对图中每个点进行拓扑排序
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
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
    }


    public static void main(String[] args) {
        CourseTable ct = new CourseTable();

        int numCourses = 5;
        int[][] pre = {{1,4}, {2,4}, {3,1}, {3,2}};

        boolean result = ct.canFinish(numCourses, pre);
        System.out.print(result);
    }
}
