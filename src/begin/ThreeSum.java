package begin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 数据从小到大排列
        Arrays.sort(nums);

        // 解题的关键在于跳出三重循环
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复数据
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            // 第二个数字从头开始，第三个数字从尾部开始
            int k = nums.length - 1;
            int target = -nums[i];

            for (int j = i+1; j < nums.length; j++) {
                // 跳过重复数据
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                // 满足j<k的前提条件
                // 因为数据是从小到大的，所以如果和大于目标值，那么应该左移第三个数
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                // 第二个数和第三个数相遇说明没有结果
                if (j == k) {
                    break;
                }

                if (nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
