package array_and_string.conclude;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {
//    public void rotate(int[] nums, int k) {
//
//        //如果位移长度大于数组长度，说明多位移了几圈
//        k = k % nums.length;
//
//        if (k == 0){
//            return;
//        }
//
//        //设置长度为k的数组存储位移后会超出的元素
//        int[] tmps = new int[k];
//
//        for (int i = tmps.length-1; i >= 0; i--){
//            tmps[i] = nums[nums.length + i - k];
//        }
//
//        //从后往前交换元素
//        for (int i = nums.length-1; i >= k; i--){
//            int index = i-k;
//            int tmp = nums[i];
//            nums[i] = nums[index];
//            nums[index] = tmp;
//        }
//
//        //将超出的元素补上
//        for (int i = 0; i < tmps.length; i++){
//            nums[i] = tmps[i];
//        }
//    }

    public void rotate(int[] nums, int k) {
        if (nums.length < k) {
            k = k % nums.length;
        }
        SwapInPair(nums, 0, nums.length - k);
        SwapInPair(nums, nums.length - k, nums.length);
        SwapInPair(nums, 0, nums.length);
    }

    private void SwapInPair(int[] nums, int left, int right) {
        int l = left, r = right - 1;
        while (l < r) {
            int tmp = nums[r];
            nums[r--] = nums[l];
            nums[l++] = tmp;
        }
    }
}
