package past.random_problem;

import java.util.*;

public class RestoreArray {

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;

        if (n == 2){
            return adjacentPairs[0];
        }

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                ret[0] = e;
                break;
            }
        }

        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }

    public static void main(String[] args) {
        RestoreArray ra = new RestoreArray();

        int[][] adjacentPairs = {{4,-2},{1,4},{-3,1}};
        int[] array = ra.restoreArray(adjacentPairs);

        for (int i : array){
            System.out.print(i);
            System.out.print(' ');
        }
    }
}
