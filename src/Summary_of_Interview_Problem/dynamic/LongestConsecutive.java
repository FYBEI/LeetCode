package Summary_of_Interview_Problem.dynamic;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    /**
     * 非正经算法，先排序，再找连续最长
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }else if (nums.length == 1){
            return 1;
        }

        int maxLen = 1;

        Arrays.sort(nums);

        int len = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1] + 1){
                len++;
            }else if (nums[i] > nums[i-1] + 1){
                if (len > maxLen){
                    maxLen = len;
                }
                len = 1;
            }
        }

        if (len > maxLen){
            maxLen = len;
        }

        return maxLen;
    }

    /**
     * 官方算法，哈希表
     */
    public int longestConsecutive2(int[] nums){

        // 先将数组存入set中去重
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {

            // 不包含比这个数小1的数，说明该数是起始位置
            if (!num_set.contains(num - 1)) {

                // 当前数字，当前长度
                int currentNum = num;
                int currentStreak = 1;

                // 往后递推寻找
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // 记录最长长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int maxLen = lc.longestConsecutive(nums);
        System.out.print(maxLen);
    }
}
