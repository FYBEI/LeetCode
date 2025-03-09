package past.search.practice;

public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if (m == 1) {
            return sum;
        }
        if (m == nums.length) {
            return max;
        }

        long low = max, high = sum;

        //low为最大值，high为总数，mid为总数去掉最大值，将剩下的值平均后加到最大值上
        //接着遍历叠加数组，一旦tsum大于mid，就将之前的值划分为一组（count起始为1，因为nums本身就算一组
        //如果count>mid，说明可以划分出更多组，使其最小的和大于mid，说明mid过小，增大mid
        //如果数组遍历完全后，count未大于m，说明mid过大，无法划分出足够的分组，再缩小mid的范围
        //当low==high，说明最后找到合适的mid，使得count满足m
        while (low < high) {
            long mid = low + (high - low) / 2;
            int count = 1, tsum = 0;
            for (int i = 0; i < nums.length; ++i) {
                tsum += nums[i];
                if (tsum > mid) {
                    ++count;
                    tsum = nums[i];
                    if (count > m) {
                        break;
                    }
                }
            }
            if (count > m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }
}
