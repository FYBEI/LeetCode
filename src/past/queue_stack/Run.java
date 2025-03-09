package past.queue_stack;

import org.junit.Assert;
import org.junit.Test;
import past.queue_stack.conclude.DecodeString;
import past.queue_stack.conclude.*;
import past.queue_stack.queue.MyCircularQueue;
import past.queue_stack.queue.NumInlands;
import past.queue_stack.queue.NumSquare;
import past.queue_stack.queue.OpenLock;
import past.queue_stack.stack.*;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void minstack(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        int min = minStack.getMin();
        Assert.assertEquals(-3, min);

        minStack.pop();

        int top = minStack.top();
        Assert.assertEquals(0, top);

        min = minStack.getMin();
        Assert.assertEquals(-2, min);
    }

    @Test
    public void isValid(){
        ValidBrackets validBrackets = new ValidBrackets();

        String test1 = "([)]";
        String test2 = "{[]}";

        boolean result1 = validBrackets.isValid(test1);
        Assert.assertFalse(result1);

        boolean result2 = validBrackets.isValid(test2);
        Assert.assertTrue(result2);
    }

    @Test
    public void daily(){
        DailyTemperature dailyTemperature = new DailyTemperature();

        int[] test = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = dailyTemperature.dailyTemperatures(test);

        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    @Test
    public void evalRPN(){
        EvalRPN evalRPN = new EvalRPN();

        String[] test = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int exp = 22;

        int result = evalRPN.evalRPN(test);
        Assert.assertEquals(exp, result);
    }

    @Test
    public void findTarget(){
        FindTarget findTarget = new FindTarget();

        int[] nums = {1, 1, 1, 1, 1, 1};
        int target = 4;

        int exp = 6;

        int result = findTarget.findTargetSumWays(nums, target);
        Assert.assertEquals(exp, result);
    }

    @Test
    public void stackQueue(){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        int a = queue.peek();  // 返回 1
        Assert.assertEquals(1, a);

        a = queue.pop();   // 返回 1
        Assert.assertEquals(1, a);

        boolean empty = queue.empty(); // 返回 false
        Assert.assertFalse(empty);
    }

    @Test
    public void queueStack(){

        MyStack obj = new MyStack();

        obj.push(2);
        obj.push(3);
        obj.push(4);

        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();

        Assert.assertEquals(4, param_2);
        Assert.assertEquals(3, param_3);
        Assert.assertFalse(param_4);
    }

    @Test
    public void decodeString() {
        DecodeString decodeString = new DecodeString();

        String test = "2[abc]3[cd]ef";
        String result = decodeString.decodeString(test);

        System.out.print(result);
    }

    @Test
    public void floodfill(){
        FloodFill floodFill = new FloodFill();

        int[][] image = {{0,0,0},{0,1,0}};

        int sr = 1, sc = 1;
        int newColor = 2;

        int[][] result = floodFill.floodFill2(image, sr, sc, newColor);

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    @Test
    public void updateMatrix(){
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();

        int[][] test = {{0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}};

        int[][] result = zeroOneMatrix.updateMatrix(test);

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    @Test
    public void keyRoom(){
        KeyAndRoom keyAndRoom = new KeyAndRoom();

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        List<Integer> room3 = new ArrayList<>();

        room0.add(1);room0.add(3);
        room1.add(3);room1.add(0);room2.add(1);
        room2.add(2);
        room3.add(0);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        boolean result = keyAndRoom.canVisitAllRooms(rooms);
        Assert.assertFalse(result);
    }
}
