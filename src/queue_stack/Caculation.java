package queue_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Caculation {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> signs = new Stack<>();

        int num = 0;
        int n = s.length();

        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);

            // 数字的话就不断叠加
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }

            // 非数字的话需要判断前一个符号
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                // 遇见 ） 则将之前的数字进行出栈计算
                // 数字栈和操作符栈同时出栈，直到遇见 （ 为止，
                if (ch == ')'){
                    int tmp = 0;
                    while (signs.peek() != '('){
                        char sign = signs.pop();

                        // 先弹出操作符，因为最后一个数字还没有入栈
                        if (sign == '+'){
                            tmp += num;
                        }else {
                            tmp -= num;
                        }
                        // 然后将下一个要计算的数字出栈
                        num = nums.pop();
                    }
                    // 最后一个操作符（，其后的数字默认为正数
                    signs.pop();
                    num = tmp + num;
                }
                // 遇见 （ 则将符号入栈
                else if (ch == '('){
                    signs.push(ch);
                }
                // 遇见+ - 则将符号入栈，数字入栈，操作数初始化为0
                else {
                    signs.push(ch);
                    nums.push(num);
                    num = 0;
                }
            }
        }

        int ans = 0;
        // 操作符栈还没空，则继续进行出栈计算，方法同上
        while (!signs.isEmpty()){
            char sign = signs.pop();
            if (sign == '+'){
                ans += num;
            }else {
                ans -= num;
            }
            num = nums.pop();
        }
        ans += num;

        return ans;
    }

    /**
     * 维护单操作符栈，根据栈顶符号变更计算符
     * @param s
     * @return
     */
    public int calculate2(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            }
            // 遇见（，则将括号前的操作符压栈
            else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;

                // 计算操作数
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                // 如果操作符为-，则sign为-1，如果操作符为+，则sign为1
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Caculation c = new Caculation();

        String s = "(1+(4+5+2)-3)+(6+8)";
        int ans = c.calculate(s);

        System.out.println(ans);
    }
}
