package past.prefixSum;

import java.util.HashMap;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum sas = new SubarraySum();

        int[] nums = {2,2,6};
        int k = 0;
        int ans = sas.subarraySum(nums, k);

        System.out.println(ans);
    }
}
