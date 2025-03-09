package past.hash.hash_set;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    /**
     * 使用HashSet
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                set.remove(nums[i]);
            }
        }

        for (int num : set){
            return num;
        }

        return 0;
    }

    /**
     * 使用异或计算
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums){
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        return x;
    }
}
