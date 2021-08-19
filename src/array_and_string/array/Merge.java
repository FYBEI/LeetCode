package array_and_string.array;

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
 * 示例 2：
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

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        start[0] = intervals[0][0];
        end[0] = intervals[0][1];
        int index = 0;

        for (int i = 1; i < intervals.length; i++) {

            // 区间在前一个区间之外，建立新的区间
            if (intervals[i][1] < start[index] || intervals[i][0] > end[index]){
                index++;
                start[index] = intervals[i][0];
                end[index] = intervals[i][1];
            }   // 区间包含前一个区间，更新前一个区间首尾
            else if (intervals[i][0] < start[index] && end[index] < intervals[i][1]){
                start[index] = intervals[i][0];
                end[index] = intervals[i][1];
            }   // 前一个区间包含区间，无视
            else if (start[index] <= intervals[i][0] && intervals[i][1] <= end[index]){
                continue;
            }   // 剩下区间相交的情况
            else {
                if (intervals[i][0] < start[index]){
                    start[index] = intervals[i][0];
                }
                if (end[index] < intervals[i][1]){
                    end[index] = intervals[i][1];
                }
            }
        }

        int[][] result = new int[index+1][];
        for (int i = 0; i < index+1; i++){
            result[i] = new int[]{start[i], end[i]};
        }

        return result;
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
