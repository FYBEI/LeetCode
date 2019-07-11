package queue_stack.conclude;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s.length() == 0){
            return s;
        }

        Set<Character> numbers = new HashSet<>();
        numbers.add('1');numbers.add('2');numbers.add('3');numbers.add('4');numbers.add('5');
        numbers.add('6');numbers.add('7');numbers.add('8');numbers.add('9');numbers.add('0');

        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();

        StringBuilder numStr = new StringBuilder();
        StringBuilder strStr = new StringBuilder();

        //s拆分成数字和字母后一一放入栈中
        for (int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            //读取一串数字数字，遇见非数字的后，就将数字存入栈中，并且重置numStr
            if (numbers.contains(c)){
                numStr.append(c);
            }

            //读取字母部分，遇见非字母就保存入栈，并且重置strStr（可能存在s末尾还有几个字母的请求，在最后需要添加上）
            if (!numbers.contains(c) && c != '[' && c != ']'){
                strStr.append(c);
            }

            //遇见[，就把strStr和numStr依次保存入栈（[只会出现在numStr后面，所以先存入字母）
            if (c == '['){

                if (strStr.length() != 0){
                    stack.push(strStr);
                }
                if (numStr.length() != 0){
                    stack.push(numStr);
                }

                strStr = new StringBuilder();
                numStr = new StringBuilder();
            }

            //遇见]，则stack顶部依次往下读到一个num
            if(c == ']'){

                //读到数字就跳出，否则取出字母后再拼接
                while (!stack.empty()){
                    StringBuilder top = stack.peek();
                    if (numbers.contains(top.charAt(0))){
                        break;
                    }

                    strStr.insert(0, top);
                    stack.pop();
                }

                int num = Integer.parseInt(stack.pop().toString());

                //将字母串按个数拼接，之后再添入栈中
                StringBuilder tmp = new StringBuilder();
                for (int j = 1; j <= num; j++){
                    tmp.append(strStr);
                }
                stack.push(tmp);
                strStr = new StringBuilder();
            }
        }

        //将栈中剩下的全部字母串拼接（s中数字和[]符号数量相等，s读取完后栈中一定没有数字
        while (!stack.empty()){
            StringBuilder top = stack.pop();

            sb.insert(0, top);
        }

        //如果strStr还包含字母，说明s不是以]结尾，需要在把字母添加到末尾
        if (strStr.length() != 0){
            sb.append(strStr);
        }

        return sb.toString();
    }
}
