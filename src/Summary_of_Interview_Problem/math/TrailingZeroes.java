package Summary_of_Interview_Problem.math;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */
public class TrailingZeroes {

    // 使用计算因子，尾数为0，说明可以被10整除，由于5*任意偶数均为10的倍数，所以只需检查5的幂
    // 同时考虑多个5的因子，即n/5 + n/25 + n/125 + ……
    public int trailingZeroes(int n) {
        int count = 0;

        // 循环5的幂
        long currentMultiple = 5;
        while (n >= currentMultiple){
            count += (n/currentMultiple);
            currentMultiple *= 5;
        }

        return count;
    }
}
