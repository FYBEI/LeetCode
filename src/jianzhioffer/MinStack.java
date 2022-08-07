package jianzhioffer;

import java.util.*;

class MinStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void push(int x) {
        int min = min();
        if (x < min) {
            stack2.push(x);
        }else {
            stack2.push(min);
        }
        stack1.push(x);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stack2.peek();
    }
}
