package sort;

import java.util.Random;

public class QuickSort {
    public int[] sortArray(int[] nums){

        randQuickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void randQuickSort(int[] nums, int l, int r){
        if (l < r){
            int pos = randPartition(nums, l, r);
            randQuickSort(nums, l, pos-1);
            randQuickSort(nums, pos+1, r);
        }
    }

    private int randPartition(int[] nums, int l, int r){
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(nums, pos, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r){
        int pivot = nums[r];

        int i = l;
        for (int j = l; j < r; j++){
            if (nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
