package queue_stack.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == 0){
            return "0";
        }else if (num.length() == k){
            return "0";
        }

        char[] str = num.toCharArray();
        // 递增栈，当小于等于栈顶元素，则添加
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // 记录删除字符的个数
        int j = 0;

        for (int i = 0; i < str.length; i++){
            char ch = str[i];
            // 删除字符个数达到上限，则直接添加
            if (j == k){
                stack.push(ch);
                continue;
            }

            // 空栈、栈顶元素小于等于当前元素，则添加；否则将栈顶大于其的元素全部弹出，直到达到删除个数上限
            if (stack.isEmpty() || ch >= stack.peek()){
                stack.push(ch);
            }else {
                while (!stack.isEmpty() && stack.peek() > ch){
                    stack.pop();
                    j++;
                    if (j == k){
                        break;
                    }
                }
                stack.push(ch);
            }
        }

        // 如果删除个数没达到上限，则从栈顶开始删除
        while (j < k){
            j++;
            stack.pop();
        }

        // 从栈底开始往字符串中添加字符
        while (!stack.isEmpty()){
            char ch = stack.pollLast();

            // 避免首位0
            if (sb.length() == 0 && ch == '0'){
                continue;
            }
            sb.append(ch);
        }

        // 剩余为0
        if (sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "112";
        int k = 1;

        RemoveKdigits rk = new RemoveKdigits();
        String s = rk.removeKdigits(num, k);
        System.out.println(s);
    }
}
