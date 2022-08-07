package jianzhioffer;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // 如果之前存在连续和不为负数的子序列，则带上之前的子序列，否则重新计算
            if (dp[i-1] >= 0) {
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
