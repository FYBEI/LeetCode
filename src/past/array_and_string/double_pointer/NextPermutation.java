package past.array_and_string.double_pointer;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 从后往前找第一个较小数，较小数为比后一位小的数
        int i = n-2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        // 找到较小数，如果i < 0，说明整个数组降序排列
        if (i >= 0){

            // 在[i+1, n) 的范围内找较大数，较大数为第一个比较小数大的数字，交换较小数和较大数
            for (int j = n-1; j > i; j--){
                if (nums[j] > nums[i]){
                    swap(nums, i, j);
                    break;
                }
            }
        }

        // 从之前较小数的位置（现在较大数的位置）之后一位开始反转，如果没有最小数，则从头开始
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
