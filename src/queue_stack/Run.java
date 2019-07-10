package queue_stack;

import org.junit.Assert;
import org.junit.Test;
import queue_stack.queue.MyCircularQueue;
import queue_stack.queue.NumInlands;
import queue_stack.queue.NumSquare;
import queue_stack.queue.OpenLock;

public class Run {

    @Test
    public void QueueTest(){
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        boolean inOrde;
        int item;

        inOrde = circularQueue.enQueue(1);  // 返回 true
        Assert.assertTrue(inOrde);

        inOrde = circularQueue.enQueue(2);  // 返回 true
        Assert.assertTrue(inOrde);

        inOrde = circularQueue.enQueue(3);  // 返回 true
        Assert.assertTrue(inOrde);

        inOrde = circularQueue.enQueue(4);  // 返回 false，队列已满
        Assert.assertFalse(inOrde);

        item = circularQueue.Rear();  // 返回 3
        Assert.assertEquals(3, item);

        inOrde = circularQueue.isFull();  // 返回 true
        Assert.assertTrue(inOrde);

        inOrde = circularQueue.deQueue();  // 返回 true
        Assert.assertTrue(inOrde);

        inOrde = circularQueue.enQueue(4);  // 返回 true
        Assert.assertTrue(inOrde);

        item = circularQueue.Rear();  // 返回 4
        Assert.assertEquals(4, item);
    }

    @Test
    public void numIsland(){
        char[][] grid = {{'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};

        NumInlands numInlands = new NumInlands();

        int num = numInlands.numIslands(grid);
        int expect = 4;

        Assert.assertEquals(expect, num);
    }

    @Test
    public void openLock(){
        OpenLock openLock = new OpenLock();

        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        int num = openLock.openLock(deadends, target);
        Assert.assertEquals(6, num);
    }

    @Test
    public void numSquare(){
        NumSquare numSquare = new NumSquare();

        int num = numSquare.numSquares3(12);
        int exp = 3;

        Assert.assertEquals(exp, num);
    }
}
