package Tencent.array_string;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        //从头来，每项等于其之前所有项的积，第一项乘1
        int n = 1;
        for (int i = 0; i < nums.length; i++){
            result[i] = n;
            n *= nums[i];
        }

        //从尾部来，每项等于其后所有项的积，尾项乘1
        n = 1;
        for (int i = nums.length-1; i >= 0; i--){
            result[i] *= n;
            n *= nums[i];
        }

        return result;
    }
}
