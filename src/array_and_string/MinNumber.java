package array_and_string;

import java.util.*;

public class MinNumber {
    public String minNumber(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return "";
        }else if (n == 1){
            return String.valueOf(nums[0]);
        }

        String[] inums = new String[n];
        for (int i = 0; i < n; i++){
            inums[i] = String.valueOf(nums[i]);
        }
        StringBuilder ans = new StringBuilder();

        Arrays.sort(inums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return (o1+o2).compareTo(o2+o1);
            }
        });

        for (int i = 0; i < n; i++){
            ans.append(inums[i]);
        }
        return ans.toString();
    }
}
