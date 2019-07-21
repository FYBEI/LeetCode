package search.model2;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class MinNum {
    public int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;

        while (left < right){
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return nums[left];
    }

    /**
     * 注意数组中可能存在重复的元素。
     *
     * 输入: [2,2,2,0,1]
     * 输出: 0
     * @param nums
     * @return
     */
    public int findMin2(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;

        while (left < right){
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }else if (nums[mid] == nums[right]){
                if (nums[mid] > nums[left]){
                    right = mid;
                }else if (nums[mid] <= nums[left]){
                    left++;
                    right--;
                }
            }
        }

        return nums[left];
    }

}
