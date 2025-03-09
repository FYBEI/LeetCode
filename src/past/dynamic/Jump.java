package past.dynamic;

public class Jump {

    // 动态规划版
    public boolean canJump(int[] nums) {

        int n = nums.length;
        if (n == 1){
            return true;
        }

        // dp[i]表示从i到n-1是否可达
        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        // 从倒数第二位开始遍历
        for (int i = n-1; i >= 0; i--){
            // 如果nums[i] 大于i到n-1的距离，则可达
            if (nums[i] >= n-i-1){
                dp[i] = true;
            }   // 否则寻找i的可达点中是否有可达末尾的点
            else {
                for (int j = 1; j <= nums[i]; j++){
                    if(dp[i+j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }

    // 贪心算法版
    public boolean canJump2(int[] nums){
        int n = nums.length;
        int rightmost = 0;

        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {

                // 最远距离为，当前最远距离和i可达的最远距离的最大值
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();

        int[] nums = {2, 3, 1, 0, 4};
        boolean res = jump.canJump(nums);
        System.out.println(res);
    }
}
