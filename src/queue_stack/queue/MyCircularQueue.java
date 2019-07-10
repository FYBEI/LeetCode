package queue_stack.queue;

/**
 * 使用java.List实现的循环队列
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

public class MyCircularQueue {
    private List<Integer> data;
    private int total;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new ArrayList<>(k);
        total = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //判断队列是否已满
        if (total == data.size()){
            return false;
        }

        data.add(value);

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (data.size() == 0){
            return false;
        }

        data.remove(0);
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (data.size() == 0){
            return -1;
        }

        return data.get(0);
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (data.size() == 0){
            return -1;
        }

        return data.get(data.size()-1);
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (data.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (data.size() == total){
            return true;
        }else {
            return false;
        }
    }
}
