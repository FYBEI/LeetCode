package Summary_of_Interview_Problem.math;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 count ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 示例 1：
 * 输入：count = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 count 中。
 *
 * 示例 2：
 * 输入：count = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 count 中。
 *
 * 示例 3：
 * 输入：count = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 count 中。
 *
 * 示例 4：
 * 输入：count = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 count 中。
 */
public class MissingNumber {

    // 位运算，a^0=a，a^a=0
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int xor = 0;
        for (int i = 0; i < n; i++){
            // num[i]^(i+1)，相当于每个数字出现两次，^运算后为0，缺少的数字只出现一次，所以最终结果就是缺少的数字
            xor ^= nums[i] ^ (i+1);
        }

        return xor;
    }

    // 等差数列求和，由于n+1个数字中缺少1个数字，这n+1个数字满足等差数列，根据公式求和，查看缺了拿一个即可
    public int missingNumber2(int[] nums) {
        int n = nums.length;

        int sum = (0 + n) * (n + 1)/2;
        for (int i = 0; i < n; i++){
            sum -= nums[i];
        }

        return sum;
    }
}
