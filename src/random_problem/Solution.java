package random_problem;

import java.util.*;

public class Solution {
    int n;
    int[] b;

    public Solution(int n, int[] blacklist) {
        this.n = n;
        Arrays.sort(blacklist);
        b = blacklist;
    }

    public int pick() {
        int k = new Random().nextInt(n-b.length);
        int lo = 0;
        int hi = b.length - 1;

        while (lo < hi){
            int mid = (lo + hi + 1) / 2;
            if (b[mid] - mid > k){
                hi = mid - 1;
            }else {
                lo = mid;
            }
        }

        return lo == hi && b[lo] - lo <= k ? k + lo + 1 : k;
    }
}

class Solution2 {

    Map<Integer, Integer> m;
    Random r;
    int wlen;

    public Solution2(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();

        // 白名单长度
        wlen = n - b.length;
        // 白名单
        Set<Integer> w = new HashSet<>();
        // 获得值大于wlen的白名单
        for (int i = wlen; i < n; i++) {
            w.add(i);
        }
        for (int x : b) {
            w.remove(x);
        }

        // 将小于wlen的黑名单数，映射到大于wlen的白名单中
        Iterator<Integer> wi = w.iterator();
        for (int x : b)
            if (x < wlen)
                m.put(x, wi.next());
    }

    public int pick() {
        // 如果随机数存在映射，说明此随机数在黑名单中，返回其白名单的映射；如果不存在映射，说明不在黑名单
        int k = r.nextInt(wlen);
        return m.getOrDefault(k, k);
    }
}

