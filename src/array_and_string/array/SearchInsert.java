package array_and_string.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        // 判断特殊情况，目标数就在边界上
        if (target < nums[left]){
            return left;
        }else if (target > nums[right]){
            return right+1;
        }

        if (target == nums[left]){
            return left;
        }else if (target == nums[right]){
            return right;
        }

        int index = binaryfind(nums, target, left, right);
        return index;
    }

    // 二分查找
    private int binaryfind(int[] nums, int target, int left, int right){

        // 当left等于right时，判断当前数和目标值的关系；left大于right时说明目标数大于right
        if (left == right){
            if (target <= nums[left]){
                return left;
            }else {
                return left + 1;
            }
        }else if (left > right){
            return left;
        }

        int mid = (left + right)/2;
        if (target == nums[mid]){
            return mid;
        }else if (target > nums[mid]){
            left = mid + 1;
        }else if (target < nums[mid]){
            right = mid - 1;
        }

        return binaryfind(nums, target, left, right);

    }

    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();

        int[] nums = {1, 3};
        int target = 2;

        int index = si.searchInsert(nums, target);
        System.out.println(index);
    }
}
