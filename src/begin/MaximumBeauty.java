package begin;

public class MaximumBeauty {

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        if (queries == null) {
            return null;
        }
        int[] result = new int[queries.length];

        // 和items一样大的临时数组，主要作用是对price和value做排序，并且过滤掉无用数据
        // tmp[i][1]表示price小于tmp[i][0]的最大value
        int[][] tmp = new int[items.length][2];
        for (int[] item : items) {
            int price = item[0];
            int value = item[1];

            // 排序算法，想象阶梯状排序：
            // 如果 price[i-1] < price[i] 且 value[i-1] < value[i]，则上一层阶梯判断
            // 如果 price[i-1] <= price[i] 但 value[i-1] >= value[i]，则替换掉当前阶梯
            // 如果 price[i-1] >= price[i] 但 value[i-1] <= value[i]，则舍弃当前值
            // 如果 price[i-1] > price[i] 且 value[i-1] > value[i]，则需要在顶替这一级阶梯，将整个阶梯后移
            for (int j = 0; j < tmp.length; j++) {
                // 初始化数据，直接赋值
                if (tmp[j][0] == 0) {
                    tmp[j][0] = price;
                    tmp[j][1] = value;
                    break;
                }

                if (tmp[j][0] < price && tmp[j][1] >= value) {
                    break;
                }
                if (tmp[j][0] >= price && tmp[j][1] <= value) {
                    tmp[j][0] = price;
                    tmp[j][1] = value;
                    break;
                }
                // 到下一级别判断
                if (tmp[j][0] < price && tmp[j][1] < value) {
                    continue;
                }
                // 需要将整个数组后移，但是数组位移的时间代价很大，所以采用替换当前值的方法，将替换后的值放到下一级别判断，从而省去一个loop
                if (tmp[j][0] > price && tmp[j][1] > value) {
                    price += tmp[j][0];
                    value += tmp[j][1];
                    tmp[j][0] = price - tmp[j][0];
                    tmp[j][1] = value - tmp[j][1];
                    price -= tmp[j][0];
                    value -= tmp[j][1];
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int r = 0;
            for (int[] ints : tmp) {
                // 无结果
                if (ints[0] == 0) {
                    result[i] = 0;
                    break;
                }
                // price > q，超出限制，则退出循环
                if (ints[0] > queries[i]) {
                    break;
                }
                // 取最大value
                r = Math.max(r, ints[1]);
            }
            result[i] = r;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] items = {
                {1,2},
                {3,2},
                {2,4},
                {5,6},
                {3,5}
        };
        int[] queries = {1,2,3,4,5,6};

        int[] result = maximumBeauty(items, queries);
        for (int j : result) {
            System.out.println(j);
        }
    }
}
