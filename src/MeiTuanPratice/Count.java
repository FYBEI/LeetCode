package MeiTuanPratice;

import java.util.*;

public class Count {

    public List<Integer> count(int n, int k, int[] A) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        // 众数
        int znum = 0;
        int z = 0;

        // 先求出前k个数字的众数
        int i = 0;
        for (; i < k; i++) {
            int num = map.getOrDefault(A[i], 0) + 1;
            if (num > znum) {
                z = A[i];
                znum = num;
            }else if (num == znum) {
                z = Math.min(z, num);
            }

            map.put(A[i], num);
        }
        res.add(z);

        for (; i < n; i++) {
            // 更新移出和移入的数字的个数
            map.put(A[i-k], map.get(A[i-k])-1);
            map.put(A[i], map.getOrDefault(A[i], 0)+1);

            if (A[i-k] == A[i]) {
                res.add(z);
                continue;
            }

            // 如果移除的数字为众数，则遍历更新众数
            if (A[i-k] == z) {
                znum--;
                for (int j = i-k+1; j <= i; j++) {
                    if (map.get(A[j]) >= znum) {
                        z = Math.min(z, A[j]);
                        znum = map.get(A[j]);
                    }
                }

            }else {
                // 如果移入的数字为众数，则众数不变
                if (A[i] == z) {
                    znum++;
                }else {
                    // 如果移入的数字不为众数，比较该数字和众数的个数
                    if (map.get(A[i]) > znum) {
                        z = A[i];
                        znum = map.get(z);
                    }else if (map.get(A[i]) == znum){
                        z = Math.min(z, A[i]);
                    }
                }

            }

            res.add(z);

        }

        return res;
    }

    public static void main(String[] args) {
        Count count = new Count();
        int n = 6;
        int k = 3;
        int[] A = {1, 2, 2, 1, 3, 1};

        List<Integer> res = count.count(n, k, A);
        for (Integer i:res) {
            System.out.println(i);
        }
    }
}
