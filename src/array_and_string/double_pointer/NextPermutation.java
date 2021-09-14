package array_and_string.double_pointer;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        if (n <= 1){
            return;
        }

        if (n == 2){
            swap(nums, 0, 1);
            return;
        }

        int j = n-1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
