package past.queue_stack.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElements nge = new NextGreaterElements();

        int[] nums = {1,2,3,2,1};
        int[] ans = nge.nextGreaterElements(nums);

        for (int i:ans){
            System.out.print(i + " ");
        }
    }
}
