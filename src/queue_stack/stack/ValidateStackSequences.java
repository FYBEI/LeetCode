package queue_stack.stack;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < pushed.length; i++){
            int val = pushed[i];
            stack.push(val);

            while (!stack.isEmpty()){
                if (popped[j] == stack.peek()){
                    stack.pop();
                    j++;
                }else {
                    break;
                }
            }
        }

        while (!stack.isEmpty()){
            int val = stack.pop();

            if (val != popped[j++]){
                return false;
            }
        }

        return true;
    }
}
