package hash.hash_map;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNum {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                int start = map.get(nums[i]);
                if ((i - start) <= k){
                    return true;
                }
                map.replace(nums[i], start, i);
            }else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
