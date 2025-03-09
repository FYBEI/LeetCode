package past.hash;

import java.util.*;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int[] count = new int[nums.length];
        for (int n : nums){
            count[n-1]++;
        }
        for (int i = 0; i < count.length; i++){
            if (count[i] == 2){
                ans.add(i+1);
            }
        }

        return ans;
    }

    /**
     * 不使用额外空间
     */
    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(int i:nums){
            // 在出现的数字对应的下标的元素上加上数组长度
            // 当取下标的时候，用%运算可以找回原数字
            nums[(i-1)%n] = nums[(i-1)%n]+n;

        }
        for(int i=0;i<n;i++){
            // 出现两次的数字所对应元素一定大于2n（原数字上加上2n），出现三次则会至少达到 3n+1
            if(nums[i] < 3*n+1 && nums[i] > 2*n){
                ans.add(i+1);
            }
        }
        return ans;

    }
}
