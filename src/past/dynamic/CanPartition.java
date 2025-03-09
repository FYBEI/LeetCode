package past.dynamic;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 只有一个元素，返回false
        if (n == 1){
            return false;
        }

        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }

        // 如果数组不为偶数，则不可分为两部分
        if (sum % 2 != 0){
            return false;
        }

        // 目标数为数组和的一半
        int target = sum/2;
        // 最大数字比目标数大，返回false
        if (maxNum > target){
            return false;
        }

        // dp[i][j]表示前i个元素是否有和为j
        boolean[][] dp = new boolean[n][target + 1];

        // 初始化状态
        // j = 0 的时候，全部为true，即都不选
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        // 选取第一个元素，则目标为nums[0]为true
        dp[0][nums[0]] = true;

        // 状态转移
        // 当j >= count[i]，说明可以选取nums[i]，那么dp[i][j] 的结果有两种，即选择了nums[i]和未选择nums[i]
        // 选择nums[i] 则结果为 dp[i-1][j - count[i]]；未选择nums[i]，则结果为num[i-1][j]
        // 当j < count[i]，说明无法选取nums[i]，则结果为 dp[i-1][j]
        for (int i = 1; i < n; i++){
            for (int j = 0; j < target+1; j++){
                if (j >= nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][target];
    }
}
