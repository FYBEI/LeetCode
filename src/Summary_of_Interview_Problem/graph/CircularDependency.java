package Summary_of_Interview_Problem.graph;

import java.util.*;

public class CircularDependency {
    List<List<Integer>> depency;
    int[] visit;    // 标记每一个节点的访问标志，0代表还未访问，1代表正在访问，2代表以访问完成
    boolean valid;
    int[] order;
    int index;

    public int[] haveCircularDependency(int n, int[][] prerequisites) {
        depency = new ArrayList<>();

        for (int i = 0; i < n; i++){
            depency.add(new ArrayList<>());
        }
        visit = new int[n];

        // 建图，depency[i][j]表示j是i的前置节点
        for (int[] pre : prerequisites){
            depency.get(pre[1]).add(pre[0]);
        }

        order = new int[n];
        index = n-1;

        // 深度遍历每一个节点
        for (int i = 0; i < n && valid; i++){
            if (visit[i] == 0){
                dfs(i);
            }
        }

        if (valid){
            return order;
        }else {
            return new int[0];
        }
    }

    private void dfs(int i){

        // 正在遍历
        visit[i] = 1;
        // 遍历该节点的前置节点
        for (int v : depency.get(i)) {
            // 深度遍历其前置节点
            if (visit[v] == 0){
                dfs(v);
                if (!valid) {
                    return;
                }
            }else if (visit[v] == 1){
                valid = false;
                return;
            }
        }

        // 遍历完成
        visit[i] = 2;
        order[index--] = i;
    }
}
