package sort;

import java.util.Arrays;

public class WiggleSort {

    /**
     * 排序 + 复制
     * 先将数组排序，在平分为两份，将两份按倒序穿插排列
     */
    public void wiggleSort(int[] nums) {
        // 复制+排序，空间O(n)，时间O(nlongn)
        int[] clone = nums.clone();
        Arrays.sort(clone);

        int n = nums.length;
        int k = n/2;
        int N = n - 1;

        // 逆序穿插，从末尾和中间位置选择放入前两个
        for (int i = 0; i < n-1; i+=2){
            nums[i] = clone[N-k];
            nums[i+1] = clone[N];
            N--;
        }

        // 奇数情况下会漏掉最后一位，需要进行处理
        if (n%2 == 1){
            nums[n-1] = clone[0];
        }
    }

    /**
     * 快速选择 + 三分法
     */
    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        // 找到中位数索引
        int midIndex = quickSelect(nums, 0, n);
        int mid = nums[midIndex];

        // 三分法
        int i = 0, j = 0, k = n-1;
        while (j < k) {
            if (nums[j] > mid){
                swap(nums, j , k);
                --k;
            }else if (nums[j] < mid){
                swap(nums, j, i);
                ++i;
                ++j;
            }else {
                j++;
            }
        }

        int[] clone = nums.clone();
        int m = n/2;
        int N = n-1;
        for (i = 0; i < n-1; i+=2){
            nums[i] = clone[N-m];
            nums[i+1] = clone[N];
            N--;
        }

        if (n%2 == 1){
            nums[n-1] = clone[0];
        }
    }

    public int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[right-1];

        int i = left;
        int j = left;

        while (j < right) {
            if (nums[j] <= pivot){
                swap(nums, i, j);
                i++;
                j++;
            }else {
                j++;
            }
        }

        if (i-1 > nums.length/2) {
            return quickSelect(nums, left, i-1);
        }else if (i <= nums.length/2){
            return quickSelect(nums, i, right);
        }else {
            return i-1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
