package queue_stack.stack;

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
    int min = Integer.MAX_VALUE;
    int[] stack;
    int index;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[10000];
        index = 0;
    }

    public void push(int val) {
        stack[index++] = val;

        if (val < min){
            min = val;
        }
    }

    public void pop() {
        if (stack[--index] == min){
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++){
                if (min > stack[i]){
                    min = stack[i];
                }
            }
        }

    }

    public int top() {
        return stack[index-1];
    }

    public int getMin() {
        return min;
    }
}
