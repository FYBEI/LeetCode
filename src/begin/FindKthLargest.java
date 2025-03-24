package begin;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len-1, len-k);
    }

    /**
     * 基于快排
     * @param nums
     * @param left
     * @param right
     * @param k
     * @return
     */
    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }
        // 选择最左边的值作为轴值
        int x = nums[left];
        int i = left - 1;
        int j = right + 1;
        // 将小于轴值的数移到左边，大于轴值的数移到右边
        while (i < j) {
            do {
                i++;
            }while (nums[i] < x);
            do {
                j--;
            }while (nums[j] > x);

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 结束时j记录的轴值坐标，也就是第j大的数
        // 如果k <= j, 则到轴值左侧二分寻找
        // 如果k > j, 则到轴值右侧二分寻找
        if (k <= j) {
            return quickSelect(nums, left, j, k);
        }else {
            return quickSelect(nums, j+1, right, k);
        }

    }
}
