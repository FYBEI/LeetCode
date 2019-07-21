package search.practice;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 */
public class Duplicate {
    public int findDuplicate(int[] nums) {
        int[] A = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            A[nums[i]]++;
            if (A[nums[i]] == 2){
                return nums[i];
            }
        }

        return 0;
    }

    /**
     * Leetcode上最快的答案
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;

        //fast一旦遇见重复数字，将出现一个循环，即一直等待slow到达这个循环
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        //slow到达循环后重置fast
        fast = 0;

        //slow继续这个循环，fast重头开始，在进入循环前一旦等于slow，就说明两个重复数字都被指出
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
