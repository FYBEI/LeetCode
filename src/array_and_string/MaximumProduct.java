package array_and_string;

import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n == 3){
            return nums[0] * nums[1] * nums[2];
        }

        Arrays.sort(nums);

        // 比较 最小的两个负数*最大的正数 和 最大的三个正数
        int ans = Math.max(nums[n-1] * nums[n-2] * nums[n-3], nums[0] * nums[1] * nums[n-1]);
        return ans;
    }
}
