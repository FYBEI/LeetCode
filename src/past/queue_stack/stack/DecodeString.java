package past.queue_stack.stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        // 数字栈
        Stack<Integer> nums = new Stack<>();
        // 字母栈
        Stack<StringBuilder> part = new Stack<>();
        // 先插入空的StringBuilder是为了防止其实单个字母的情况
        part.push(new StringBuilder());

        int k = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // 读取到数字，累加数字
            if ('0' <= ch && ch <= '9'){
                k = k * 10 + ch - '0';
            }
            // 读取到 [ , nums入栈
            else if (ch == '['){
                nums.push(k);
                k = 0;
                part.push(new StringBuilder());
            }
            // 读取到 ] , part栈顶元素为要累加的字符串，累加好叠加到次栈顶元素，nums栈顶为累加次数
            else if (ch == ']'){
                StringBuilder p = part.pop();
                StringBuilder kp = part.pop();
                int n = nums.pop();

                while (n > 0){
                    kp.append(p);
                    n--;
                }

                part.push(kp);
            }
            // 读取到英文字母，与part栈顶累加
            else {
                part.push(part.pop().append(ch));
            }

        }

        return part.pop().toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();

        String s = "2[abc]3[cd]ef";
        String ans = ds.decodeString(s);

        System.out.println(ans);
    }
}
