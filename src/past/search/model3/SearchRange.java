package past.search.model3;

/**
 * 给定一个按照升序排列的整数数组 count，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 输入: count = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 输入: count = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;

            if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid] > target){
                right = mid-1;
            }else {
                int begin = mid;
                int end = mid;

                while (begin >= 0 && nums[begin] == target){
                    begin--;
                }
                while (end < nums.length && nums[end] == target){
                    end++;
                }
                result[0] = begin + 1;
                result[1] = end - 1;
                break;
            }
        }

        return result;
    }
}
