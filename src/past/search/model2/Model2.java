package past.search.model2;

/**
 * 初始条件：left = 0, right = length
 * 终止：left == right
 * 向左查找：right = mid
 * 向右查找：left = mid+1
 */
public class Model2 {
    int binarySearch(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }
}
