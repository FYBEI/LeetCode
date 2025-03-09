package past.Summary_of_Interview_Problem.conclulde;

/**
 * 不使用运算符 + 和 - ，计算两整数 a、b之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class Sum {

    /**
     * 如果是负数 leetcode左移时报错 runtime error: left shift of negative value
     * 具体原因是运行时库的问题
     * 可以转换成无符号整型进行左移
     */
    public int getSum(int a, int b) {

        // 进位为0，即a为最终的求和结果
        while(b != 0){
            // 二进制每位相加就相当于各位做异或操作
            int temp = a ^ b;
            // 计算进位，相当于各位进行与操作，再向左移一位
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Sum sum = new Sum();

        int a = -2;
        int b = 3;
        int s = sum.getSum(a, b);
        System.out.print(s);
    }
}
