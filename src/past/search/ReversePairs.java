package past.search;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return 0;
        }

        // 避免修改原数组
        int[] copy = new int[len];
        for (int i = 0; i < len; i++){
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len-1, temp);
    }

    /**
     * 在nums[left…right] 区间内计算逆序对个数并进行排序
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp){
        if (left == right){
            return 0;
        }

        int mid = left + (right - left)/2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid+1, right, temp);

        // 如果两个部分已经有序，则不需要计算跨区域的逆序对
        if (nums[mid] <= nums[mid+1]){
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);

        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid+1..right]有序
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++){
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid+1;
        int count = 0;

        for (int k = left; k <= right; k++) {

            // 其中一部分全部归并完成，则将剩余部分归并
            if (i == mid+1){
                nums[k] = temp[j];
                j++;
            }else if (j == right+1){
                nums[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }else {

                // 当归并第二部分的数组时，计算第一部分还有多少元素没有被归并，即逆序对数量
                nums[k] = temp[j];
                j++;
                count += (mid + 1 - i);
            }
        }

        return count;
    }
}
