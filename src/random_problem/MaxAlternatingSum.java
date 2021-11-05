package random_problem;

/**
 * 给你一个数组 count ，请你返回 count 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
 * 一个数组的子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
 *
 * 示例 1：
 * 输入：count = [4,2,5,3]
 * 输出：7
 * 解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
 *
 * 示例 2：
 * 输入：count = [5,6,7,8]
 * 输出：8
 * 解释：最优子序列为 [8] ，交替和为 8 。
 *
 * 示例 3：
 * 输入：count = [6,2,1,2,4,5]
 * 输出：10
 * 解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
 */
public class MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        // odd记录最后选择的元素下标是奇数所得到的最大值，even记录最后选择的元素下标是偶数所得到的最大值
        long odd = 0, even = nums[0];

        // 根据是否选择nums[i]来判断状态转移
        // 如果选择了nums[i]：odd就是由偶数最大值-num得到，even就是由奇数+num得到
        for (int i = 1; i < n; i++){
            odd = Math.max(even - nums[i], odd);
            even = Math.max(odd + nums[i], even);
        }

        // 最终绝对是偶数最大
        return even;
    }
}
