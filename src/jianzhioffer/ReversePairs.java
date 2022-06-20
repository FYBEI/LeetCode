package jianzhioffer;

public class ReversePairs {
    static public int reversePairs(int[] nums) {
        int count = 0;
        int len = nums.length;

        if (len < 2) {
            return count;
        }

        count = mergeSort(nums, 0, len-1);
        return count;
    }

    static public int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int leftNum = mergeSort(nums, left, mid);
        int rightNum = mergeSort(nums, mid+1, right);

        if (nums[mid] <= nums[mid+1]) {
            return leftNum + rightNum;
        }

        int count = 0;

        int[] tmp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int index = 0;

        while (index < right-left+1) {
            if (i == mid+1) {
                tmp[index++] = nums[j++];
            }else if (j == right+1) {
                tmp[index++] = nums[i++];
            }else if (nums[i] <= nums[j]){
                tmp[index++] = nums[i++];
            }else {
                tmp[index++] = nums[j++];
                count += (mid+1-i);
            }
        }

        for (i = left; i <= right; i++) {
            nums[i] = tmp[i-left];
        }

        return leftNum + rightNum + count;
    }

    /**
     * 7,5,6,4
     *
     * 7,5  6,4
     * 1    1
     *
     * 7,6,5,4
     * 1,2
     */
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        int count = reversePairs(nums);

        System.out.println(count);
    }
}
