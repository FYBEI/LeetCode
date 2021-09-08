package Summary_of_Interview_Problem.sort_search;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {

        // 复制+排序，空间O(n)，时间O(nlongn)
        int[] clone = nums.clone();
        Arrays.sort(clone);

        int n = nums.length;
        int k = n/2;
        int N = n - 1;

        // 逆序穿插，从末尾和中间位置选择放入前两个
        for (int i = 0; i < n-1; i+=2){
            nums[i] = clone[N-k];
            nums[i+1] = clone[N];
            N--;
        }

        // 奇数情况下会漏掉最后一位，需要进行处理
        if (n%2 == 1){
            nums[n-1] = clone[0];
        }
    }

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();

        int[] nums = {1, 5, 1, 1, 6, 4};
        ws.wiggleSort(nums);

        for (int num : nums){
            System.out.println(num);
        }
    }
}
