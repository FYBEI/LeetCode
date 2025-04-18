package past.Summary_of_Interview_Problem;

import java.util.*;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        if (nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }

        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        for (int num : nums){
            if (num == cand1){
                count1++;
                continue;
            }

            if (num == cand2){
                count2++;
                continue;
            }

            if (count1 == 0){
                cand1 = num;
                count1 = 1;
                continue;
            }
            if (count2 == 0){
                cand2 = num;
                count2 = 1;
                continue;
            }

            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums){
            if (num == cand1){
                count1++;
            }else if (num == cand2){
                count2++;
            }
        }

        if (count1 > nums.length/3){
            ans.add(cand1);
        }

        if (count2 > nums.length/3){
            ans.add(cand2);
        }

        return ans;
    }
}
