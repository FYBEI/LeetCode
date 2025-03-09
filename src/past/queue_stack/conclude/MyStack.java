package past.queue_stack.conclude;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 使用队列实现栈
 */
public class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue.isEmpty()){
            queue.add(x);
            return;
        }

        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()){
            tmp.add(queue.remove());
        }
        queue.add(x);

        for (int i = 0; i < tmp.size(); i++){
            queue.add(tmp.get(i));
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue == null){
            return false;
        }

        return queue.isEmpty();
    }
}
