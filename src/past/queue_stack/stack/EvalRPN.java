package past.queue_stack.stack;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }

        Stack<String> stack = new Stack<>();

        stack.push(tokens[0]);
        stack.push(tokens[1]);

        for (int i = 2; i < tokens.length; i++){
            if (isNumber(tokens[i])){
                stack.push(tokens[i]);
            }else {
                String num2 = stack.pop();
                String num1 = stack.pop();

                String tmp = calculate(tokens[i], num1, num2);
                stack.push(tmp);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isNumber(String s){
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }

        return true;
    }

    private String calculate(String sign, String num1, String num2){
        Integer a = Integer.parseInt(num1);
        Integer b = Integer.parseInt(num2);

        Integer tmp = null;
        switch (sign){
            case "+":
                tmp = new Integer(a + b);
                break;
            case "-":
                tmp = new Integer(a - b);
                break;
            case "*":
                tmp = new Integer(a * b);
                break;
            case "/":
                tmp = new Integer(a / b);
                break;
        }

        return tmp.toString();
    }
}
