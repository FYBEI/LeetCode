package queue_stack.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {

    private List<Integer> data = null;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        if (data == null || data.size() == 0){
            return;
        }

        data.remove(data.size()-1);
    }

    public int top() {
        if (data == null || data.size() == 0){
            return 0;
        }

        return data.get(data.size()-1);
    }

    public int getMin() {
        if (data == null || data.size() == 0){
            return 0;
        }

        int min = 0;

        for (int i = 0; i < data.size(); i++){
            min = min < data.get(i) ? min : data.get(i);
        }

        return min;
    }
}
