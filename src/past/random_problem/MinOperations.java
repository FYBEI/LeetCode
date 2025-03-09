package past.random_problem;

/**
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 *
 * 示例 1：
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 *
 * 示例 2：
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 *
 * 示例 3：
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 */
public class MinOperations {
    public int minOperations(String s) {

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i)%2!=i%2) {
                count1++;
            } else{
                count2++;
            }
        }

        return count1 < count2 ? count1:count2;
    }
}
