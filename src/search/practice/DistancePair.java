package search.practice;

import java.util.Arrays;

/**
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 * 示例 1:
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 */
public class DistancePair {
    /**
     * 我们先对数组排序，我们知道排序后，距离一定在 0 ~ nums[len(nums)-1] - nums[0]之间
     * 然后我们在这个区间枚举距离d，看对于每个d，有多少对数字的距离（假设为count个） <= d，
     * 如果 count大于k了，这个距离肯定不是要求的距离，
     * 然后我们缩小范围，这里可以采用二分的思想求距离d。
     * @param nums
     * @param k
     * @return
     */

    public int smallestDistancePair(int[] nums, int k) {
        //注意这里，对数组进行排序处理
        Arrays.sort(nums);

        int len = nums.length;

        int left = 0, right = nums[len - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(nums, mid);
            //注意这里的二分查找左边界和右边界更新的标准
            //小于k，mid必然非最终解，因此left = mid + 1
            //大于等于k，可以将mid作为候选解
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int getCount(int[] nums, int mid) {
        int count = 0;

        int left = 0;
        //注意这里的left，在迭代的过程中没有重置，而是一直右移
        //很容易理解，i右移，nums[i]变大(注意对数组进行过排序)，而nums[left](上一轮的)不变
        //因此差增大，必然还是比mid大，因此不需要再迭代一遍
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] - nums[left] > mid) {
                left++;
            }
            count += i - left;
        }

        return count;
    }

}
