package past.MeiTuanPratice;

import java.util.*;

public class MultiSet {
    public int solution(int n, int m, int[] A, int[] B) {
        Map<Integer, Integer> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mapA.containsKey(A[i])) {
                mapA.replace(A[i], mapA.get(A[i])+1);
            }else  {
                mapA.put(A[i], 1);
            }
        }

        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mapB.containsKey(B[i])) {
                mapB.replace(B[i], mapB.get(B[i])+1);
            }else  {
                mapB.put(B[i], 1);
            }
        }

        for (int i = 1; i < m; i++) {
            boolean match = true;

            for (Integer num : mapA.keySet()) {
                int numMod = (num + i) % m;
                if (mapB.containsKey(numMod) && mapA.get(num) == mapB.get(numMod)) {
                    continue;
                }else {
                    match = false;
                    break;
                }
            }

            if (match) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int n = 6;
        int m = 8;
        int[] A = {1, 1, 4, 5, 1, 4};
        int[] B = {3, 0, 4, 0, 3, 0};

        MultiSet ms = new MultiSet();
        System.out.println(ms.solution(n, m, A, B));
    }
}
