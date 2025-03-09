package past.Summary_of_Interview_Problem.queue_stack;

/***
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class KthLargest {
    /**
     * 基于快速排序的方法
     */
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;

        int left = 0;
        int right = n-1;
        int target = n-k;

        while (true){
            int index = partion(left, right);
            if (index == target){
                return nums[index];
            }else if (index < target){
                left = index + 1;
            }else if (index > target){
                right = index - 1;
            }
        }
    }

    //在数组 count 的子区间 [left, right] 执行 partition 操作，返回 count[left] 排序以后应该在的位置
    //     在遍历过程中保持循环不变量的语义
    //     1、[left + 1, j] < count[left]
    //     2、(j, i] >= count[left]
    private int partion(int left, int right){
        int pivot = this.nums[left];
        int j = left;
        for (int i = left; i <= right; i++){
            if (this.nums[i] < pivot){
                j++;
                swap(i, j);
            }
        }

        swap(j, left);
        return j;
    }

    private void swap(int i, int j){
        int a = this.nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = a;
    }

    // 事实上最快
    // public int findKthLargest(int[] count, int k){
    //     Arrays.old.sort(count);
    //     return count[count.length-k];
    // }

    /**
     * 基于堆排序的方法
     */

    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 5;
        KthLargest kthLargest = new KthLargest();
        int t = kthLargest.findKthLargest(nums, k);
        System.out.println(t);
    }
}
