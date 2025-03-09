package past.Summary_of_Interview_Problem.math;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 *
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 *
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 *
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 *
 * tip: 任意两个整数相除，不会得出无限不循环小数
 */
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();

        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }

        // Convert to Long or else abs(-2147483648) overflows
        // 计算整数部分
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }

        fraction.append(".");
        // map记住余数和所除的位置
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {

            // 遇见相同的余数，从所除位置开始插入括号
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal f2d = new FractionToDecimal();

        int numerator = 1;
        int denominator = 17;
        String res = f2d.fractionToDecimal(numerator, denominator);
        System.out.print(res);
    }
}
