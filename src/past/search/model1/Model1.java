package past.search.model1;

/**
 * 初始条件：left = 0, right = length-1
 * 终止：left > right
 * 向左查找：right = mid-1
 * 向右查找：left = mid+1
 */
public class Model1 {
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }
}
