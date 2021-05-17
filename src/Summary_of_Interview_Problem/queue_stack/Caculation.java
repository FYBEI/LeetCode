package Summary_of_Interview_Problem.queue_stack;

import java.util.Stack;

public class Caculation {

    private static int START = 0;
    private static int NUM = 1;
    private static int CAL = 2;

    public int calculate(String s) {
        Stack<Character> op_stack = new Stack<>();
        Stack<Integer> num_stack = new Stack<>();
        int flag = START;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if ('0' <= ch && ch <= '9'){
                //当前输入为数字
                int num = ch - '0';

                // 如果前一个字符也为数字，需要将当前数字接在数字栈顶数字后
                if (flag == NUM){
                    int new_num = num_stack.pop()*10 + (ch - '0');
                    num_stack.push(new_num);
                }else {
                    num_stack.push(num);
                }
                flag = NUM;
            }else if (ch == ' '){
                continue;
            }else {
                if (!op_stack.isEmpty()){
                    if (op_stack.peek() == '*'){
                        op_stack.pop();
                        int second = num_stack.pop();
                        int first = num_stack.pop();
                        int new_num = first*second;
                        num_stack.push(new_num);
                    }else if (op_stack.peek() == '/'){
                        op_stack.pop();
                        int second = num_stack.pop();
                        int first = num_stack.pop();
                        int new_num = first/second;
                        num_stack.push(new_num);
                    }
                }

                op_stack.push(ch);
                flag = CAL;

            }
        }

        int result;
        while (!op_stack.isEmpty()){
            int second = num_stack.pop();
            int first = num_stack.pop();
            char op = op_stack.pop();
            if (op == '+'){
                int new_num = first + second;
                num_stack.push(new_num);
            }else if (op == '-'){
                int new_num = first - second;
                num_stack.push(new_num);
            }else if (op == '*'){
                int new_num = first * second;
                num_stack.push(new_num);
            }else if (op == '/'){
                int new_num = first / second;
                num_stack.push(new_num);
            }
        }

        result = num_stack.pop();

        return result;
    }

    public static void main(String[] args) {
        Caculation caculation = new Caculation();

        String s = "1-1+1";
        int result = caculation.calculate(s);
        System.out.print(result);
    }
}
