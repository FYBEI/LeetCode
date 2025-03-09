package past.Tencent.array_string;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 count 和 一个目标值 target。找出 count 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 count = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //判断特殊情况
        if (nums.length < 1) {
            return 0;
        }

        int ans = nums[0];
        if (nums.length < 2) {
            return ans;
        }

        ans += nums[1];
        if (nums.length < 3) {
            return ans;
        }

        ans += nums[2];
        if (nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            //全部最小的相加，如果还是比target大，说明最小的最接近
            int result = nums[i] + nums[i + 1] + nums[i + 2];
            if (target < result) {
                return Math.abs(result - target) < Math.abs(ans - target) ? result : ans;
            }

            //头一项和最大的两个相加，若过target更大，就把头一项+1
            int end = nums.length - 1;
            result = nums[i] + nums[end - 1] + nums[end];
            if (target > result) {
                if (Math.abs(result - target) < Math.abs(ans - target)) {
                    ans = result;
                }
                continue;
            }

            //如果以上两种情况都不符合，就从第二项开始，到最后一项全部相加比较
            int start = i + 1;
            while (start < end) {
                result = nums[i] + nums[start] + nums[end];
                //如果直接相等，就返回
                if (result == target) {
                    return result;
                }

                //如果相差的绝对值更小，更新
                if (Math.abs(result - target) < Math.abs(ans - target)) {
                    ans = result;
                }

                //如果和小于target，就把往高位取；否则往低位取
                if (result < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return ans;
    }
}
