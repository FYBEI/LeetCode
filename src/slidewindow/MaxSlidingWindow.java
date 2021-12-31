package slidewindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 count，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 * 输入：count = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 *
 * 示例 2：
 * 输入：count = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 * 输入：count = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 示例 4：
 * 输入：count = [9,11], k = 2
 * 输出：[11]
 *
 * 示例 5：
 * 输入：count = [4,-2], k = 2
 * 输出：[4]
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // 双端队列，记录在队列中的数字的下标
        Deque<Integer> deque = new LinkedList<Integer>();

        // 初始化，输入前k个数字，并且排出最大值之前的元素
        for (int i = 0; i < k; ++i) {

            // 如果当前数字大于之前的数字，则将之前的数字弹出
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 如果当前的下标不在范围内，说明是之前的最大值，则将该下标弹出
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] result = msw.maxSlidingWindow(nums, k);

        for (int i:result){
            System.out.print(i);
        }
    }
}
