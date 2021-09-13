package sort;

public class HeapSort {
    public int[] sortArray(int[] nums){
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums){
        int len = nums.length - 1;
        buildMaxHeap(nums, len);

        for (int i = len; i > 0; i--){
            swap(nums, 0, i);
            len--;
            maxHeapify(nums, 0, len);
        }
    }

    private void buildMaxHeap(int[] nums, int len){

        for (int i = len/2; i >=0; i--){
            maxHeapify(nums, i, len);
        }

    }

    private void maxHeapify(int[] nums, int i, int len){
        while ((i<<1) + 1 <= len){
            int large = i;
            int lchild = (i << 1) + 1;
            int rchild = (i << 1) + 2;

            if (lchild <= len && nums[lchild] > nums[i]){
                large = lchild;
            }

            if (rchild <= len && nums[rchild] > nums[large]){
                large = rchild;
            }

            if (large != i){
                swap(nums, i, large);
                i = large;
            }else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
