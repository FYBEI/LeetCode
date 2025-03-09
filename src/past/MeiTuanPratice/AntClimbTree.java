package past.MeiTuanPratice;

import java.util.*;

public class AntClimbTree {

    Map<Integer, Set<Integer>> connMap = new HashMap<>();
    int maxRes = 0;
    int minRes = Integer.MAX_VALUE;
    int[] visit;
    List<Integer> visList;

    public int[] game(int n, int m, int[] a, int[][] conn) {
        buildConnMap(m, conn);
        visit = new int[n];
        visList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            visit[i] = 1;
            visList.add(i+1);
            dfs(n, a, a[i], a[i]);
            visList.remove(visList.size()-1);
            visit[i] = 0;
        }

        return new int[]{maxRes, minRes};
    }

    private void dfs(int n, int[] a, int total, int min) {
        for (int i = 0; i < n; i++) {
            if (visit[i] == 1) {
                continue;
            }

            boolean flag = true;
            for (int j = 0; j < visList.size(); j++) {
                int num = visList.get(j);
                if (connMap.get(num).contains(i+1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                visit[i] = 1;
                visList.add(i+1);
                dfs(n, a, total+a[i], Math.min(a[i], min));
                visList.remove(visList.size()-1);
                visit[i] = 0;
            }
        }

        if (total > maxRes) {
            maxRes = total;
            if (minRes > min) {
                minRes = min;
            }
        }
    }

    private void buildConnMap(int m, int[][] conn) {
        for (int i = 0; i < m; i++) {
            int n1 = conn[i][0];
            int n2 = conn[i][1];

            if (!connMap.containsKey(n1)) {
                connMap.put(n1, new HashSet<>());
            }
            if (!connMap.containsKey(n2)) {
                connMap.put(n2, new HashSet<>());
            }

            connMap.get(n1).add(n2);
            connMap.get(n2).add(n1);
        }
    }

    public static void main(String[] args) {
        int n = 5, m = 4;
        int[] a = {3, 4, 1, 4, 9};
        int[][] conn = {
                {1,2},
                {1,3},
                {2,4},
                {3,5}
        };

        int[] res = new AntClimbTree().game(n, m, a, conn);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
