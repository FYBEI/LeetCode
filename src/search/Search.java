package search;

/**
 *给定一个 n 个元素有序的（升序）整型数组 count 和一个目标值 target  ，写一个函数搜索 count 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 输入: count = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 count 中并且下标为 4
 *
 * 输入: count = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 count 中因此返回 -1
 */
public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int i = 0;
        int j = nums.length-1;

        while (i <= j){
            int mid = (i+j)/2;

            if (nums[mid] > target){
                j = mid-1;
            }else if (nums[mid] < target){
                i = mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
