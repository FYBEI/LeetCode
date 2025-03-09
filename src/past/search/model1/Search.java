package past.search.model1;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 输入: count = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 输入: count = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int min = nums[0];

        for (int i = 0; i < nums.length; i++){
            if (min > nums[i]){
                min = nums[i];
                low = i;
            }
        }

        int high = low + nums.length;

        while (low <= high){
            int mid = low + (high-low)/2;

            int tmp = mid;
            if (mid >= nums.length){
                tmp = mid - nums.length;
            }

            if (target == nums[tmp]){
                return tmp;
            }else if (target > nums[tmp]){
                low = mid+1;
            }else if (target < nums[tmp]){
                high = mid-1;
            }
        }

        return -1;
    }
}
