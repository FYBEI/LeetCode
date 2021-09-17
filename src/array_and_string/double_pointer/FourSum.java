package array_and_string.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        if (n < 4){
            return ans;
        }

        for (int i = 0; i < n-3; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){

                // 剪枝
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }


                for (int j = i+1; j < n-2; j++){

                    if (j == i+1 || (j > i+1 && nums[j] != nums[j-1])){

                        // 剪枝
                        if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                            break;
                        }
                        if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                            continue;
                        }

                        int l = j + 1;
                        int r = n-1;
                        int sum = target - nums[i] - nums[j];

                        while (l < r){
                            if (nums[l] + nums[r] == sum) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                l++;
                                r--;
                            } else if (nums[l] + nums[r] < sum) {
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;   // 跳过重复值
                                }
                                l++;
                            } else {
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                r--;
                            }
                        }
                    }

                }
            }
        }

        return ans;
    }
}
