package Tencent.array_string;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int first = 0;

        while (first <= nums.length-3){
            int second = first + 1;

            while (second <= nums.length - 2){

                int exp = 0 - nums[first] - nums[second];

                boolean unique = true;
                for (List<Integer> element : result){
                    unique = !(element.contains(nums[first]) & element.contains(nums[second]) & element.contains(exp));
                }

                if (unique){
                    int i = second + 1;
                    for (;i < nums.length; i++){
                        if (nums[i] == exp){

                            List<Integer> element = new ArrayList<>();
                            element.add(nums[first]);
                            element.add(nums[second]);
                            element.add(exp);

                            result.add(element);
                            break;
                        }
                    }
                }

                second++;
            }

            first++;
        }

        return result;
    }
}
