package array_and_string.double_pointer.one;

import array_and_string.double_pointer.QuickSort;

/**
 *给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
public class ArrayPair {

    public int arrayPairSum(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int total = 0;

        //先进行排序，然后取下标为偶数项
        QuickSort.quickSort(nums, 0, nums.length-1);

        for (int i = 0; i < nums.length; ){
            total += nums[i];
            i += 2;
        }

        return total;
    }
}
