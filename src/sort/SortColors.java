package sort;

public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        int k = 0;

        while (k <= j) {
            while (k <= j && nums[k] == 2){
                swap(nums, k, j);
                j--;
            }

            if (nums[k] == 0){
                swap(nums, k, i);
                i++;
            }

            k++;
        }
    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                ++p1;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                ++p0;
                ++p1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j){
            return;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
