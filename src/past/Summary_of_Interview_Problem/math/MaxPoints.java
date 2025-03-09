package past.Summary_of_Interview_Problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 *
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 */
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int n = points.length;

        // 任何两个点都可以连成一条线
        if (n <= 2) {
            return n;
        }

        int ret = 0;

        for (int i = 0; i < n; i++) {

            // 当前线上最多点数超过一半或者n-i，则说明当前线上点数为最多了
            if (ret >= n - i || ret > n / 2) {
                break;
            }

            // key为斜率（斜率用分数表示，因为小数会存在精度问题），value为点数量
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            // 遍历当前点之后的点
            for (int j = i + 1; j < n; j++) {

                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }

                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    // 化为最简分数
                    x /= gcdXY;
                    y /= gcdXY;
                }

                // 将两个键值组合为一个键值，用一个32位int存储
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            // 当前点情况下，最多的点数
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            // 更新最多的点数
            ret = Math.max(ret, maxn);
        }

        return ret;
    }

    // 最小公因数
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();

        int[][] points = {{2,3}, {3,3}, {-5,3}};
        int num = maxPoints.maxPoints(points);
        System.out.print(num);
    }
}
