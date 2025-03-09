package past.Summary_of_Interview_Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊n/2⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    /**
     * 排序法，时间复杂度O(nlogn),空间复杂度O(n)
     */
    static int majorityElement(int[] nums){
        int mid = nums.length/2;

        Arrays.sort(nums);
        return nums[mid];
    }

    /**
     * 哈希表法，时间复杂度O(n),空间复杂度O(n)
     */
        static int majorityElement2(int[] nums){
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++){
                if (!counts.containsKey(nums[i])){
                    counts.put(nums[i], 1);
                }else {
                    int num = counts.get(nums[i])+ 1;

                    if (num > nums.length/2){
                        return nums[i];
                    }else {
                        counts.put(nums[i], num);
                    }

                }
            }

            return 0;
        }

    /**
     * Boyer-Moore投票算法:如果我们把众数记为+1，把其他数记为−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     * 时间复杂度：O(n),空间复杂度：O(1)
     */
    static int majorityElement3(int[] nums){
        int canditate = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++){
            //count为0时，赋予初始值
            if (count == 0){
                canditate = nums[i];
            }
            //如果初始值和当前值一样，count+1，否则count-1
            count += (nums[i] == canditate) ? 1 : -1;
        }

        return canditate;
    }

    public static void main(String[] args) {
        int[] num = {-1,1,1,1,2,1};

        int result = majorityElement3(num);
        System.out.println(result);
    }
}
