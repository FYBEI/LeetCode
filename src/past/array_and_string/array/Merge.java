package past.array_and_string.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]){
                    return -1;
                }else if (o1[0] == o2[0]){
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        int[][] result = new int[intervals.length][];
        int index = 0;

        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= end && end < e){
                end = e;
                continue;
            }

            if (s > end){
                result[index++] = new int[]{start, end};
                start = s;
                end = e;
                continue;
            }
        }
        result[index++] = new int[]{start, end};

        int[][] ans = Arrays.copyOf(result, index);

        return ans;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();

        int[][] intervals = {{2,3}, {4,5}, {6,7}, {8,9}, {1,10}};
        int[][] result = merge.merge(intervals);

        for (int[] tmp:result){
            System.out.println(tmp[0] + "," + tmp[1]);
        }
    }
}
