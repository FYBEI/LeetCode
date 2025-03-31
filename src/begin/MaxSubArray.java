package begin;

public class MaxSubArray {

    /**
     * 动态规划，O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // 记录子串累加
        int sum = 0;
        // 初始化第一位就是 nums[0]
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            // 计算和之前的累加
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            // 如果当前累加小于0，重启
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

}
