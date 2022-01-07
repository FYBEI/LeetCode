package dynamic;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {

    /**
     * 动态规划实现
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;

        // dp[i]表示已i结尾的最长有效括号的长度
        int[] dp = new int[s.length()];
        char[] charArray = s.toCharArray();

        for (int i = 1; i < s.length(); i++){

            // 只有已) 结尾才是有效括号
            if (charArray[i] == ')'){

                // 如果前一位为左括号，则凑成一对有效括号，其最长长度取决于之前的有效括号
                if (charArray[i-1] == '('){
                    dp[i] = (i >=2 ? dp[i-2]:0) + 2;
                }
                // 如果前一位不为左括号，则判断其是否可能包含有效括号，找到前一位有效括号的左括号位置，长度在其基础上+2
                else if (i - dp[i-1] > 0 && charArray[i-dp[i-1]-1] == '(') {
                    dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    /**
     * 栈实现
     */
    public int longestValidParentheses_stack(String s){
        int maxLen = 0;
        // 栈底保持最后一个未匹配的右括号的下标
        Deque<Integer> stack = new LinkedList<Integer>();

        // 一开始加入-1防止起始左括号加入
        stack.push(-1);
        // 每次遇见左括号则入栈，遇见右括号则出栈
        // 如果此时栈为空，则将此右括号入栈，表示最后一个未被匹配的右括号，因为栈底本来应该有一个-1，如果栈为空，说明该右括号匹配-1，也就是没匹配
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
            }
        }

        return maxLen;
    }

    /**
     * 贪心算法实现，不需额外的空间
     */
    public int longestValidParentheses_greedy(String s){
        int maxLen = 0;
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }

            if (left == right){
                maxLen = Math.max(maxLen, 2*right);
            }else if (right > left){
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }

            if (left == right){
                maxLen = Math.max(maxLen, 2*left);
            }else if (left > right){
                left = right = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "(())";
        LongestValidParentheses lvp = new LongestValidParentheses();
        lvp.longestValidParentheses(s);
    }
}
