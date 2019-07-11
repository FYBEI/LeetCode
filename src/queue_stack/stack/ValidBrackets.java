package queue_stack.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++){
            char tmp = s.charAt(i);

            //tmp为左括号，就加入栈中
            if (tmp == '(' || tmp == '{' || tmp == '['){
                stack.push(tmp);
            }else {

                //tmp为右括号，就从栈中取对应一半
                //如果栈空了，说明无法匹配
                if (stack.empty()){
                    return false;
                }

                //取出栈顶元素
                char left = stack.peek();

                //如果符合对应关系，就将栈顶出栈，否则返回false(这块代码可以单独拿出来写一个方法)
                if (tmp == ')' && left == '('){
                    stack.pop();
                }else if (tmp == '}' && left == '{'){
                    stack.pop();
                }else if (tmp == ']' && left == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        //最后检查栈是否为空，还有剩余项说明没有配对
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
