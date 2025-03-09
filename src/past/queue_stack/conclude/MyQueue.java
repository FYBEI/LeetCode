package past.queue_stack.conclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.empty()){
            stack.push(x);
            return;
        }

        List<Integer> tmp = new ArrayList<>();

        while (!stack.empty()){
            tmp.add(stack.pop());
        }

        stack.push(x);

        for (int i = tmp.size()-1; i >= 0; i--){
            stack.push(tmp.get(i));
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack == null){
            return true;
        }

        return stack.empty();
    }
}
