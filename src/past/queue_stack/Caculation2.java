package past.queue_stack;

import java.util.Deque;
import java.util.LinkedList;

public class Caculation2 {

    public int calculate(String s) {

        Deque<Integer> stack = new LinkedList<Integer>();

        char preSign = '+'; // 记录前一符号
        int num = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {

            // 数字的话就不断叠加
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            // 非数字的话需要判断前一个符号，+-则直接压入，乘除需要进行一次运算
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }

                // 更新前一项符号和当前数字
                preSign = s.charAt(i);
                num = 0;
            }
        }

        // 计算最先加入的一项
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Caculation2 caculation2 = new Caculation2();

        String s = "1-1*12+1";
        int result = caculation2.calculate(s);
        System.out.print(result);
    }
}
