package begin;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // 长度位1和2的特殊情况
        if (len == 1) {
            return;
        }
        if (len == 2) {
            swap(nums, 0, 1);
            return;
        }
        // 从末尾找连续递增的第一位
        int i = len - 1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        // i==0说明数组从大到小排序，逆序排序
        if (i == 0) {
            reverse(nums, 0, len-1);
            return;
        }
        // i==len-1则和前一位交换
        if (i == len-1) {
            swap(nums, len-1, len-2);
            return;
        }

        // 比较i左侧和右侧的值
        int leftNum = nums[i-1];
        int rightNum = nums[i+1];
        // 左侧大于右侧，说明左侧值大于右侧所有的值，那么下一位只能把nums[i]进一位，然后将右侧所有数逆序
        if (leftNum >= rightNum) {
            swap(nums, i-1, i);
            reverse(nums, i, len-1);
        } else {
            // 左侧小于右侧，找到右侧大于nums[i-1]的最小值，交换这两位，然后右侧逆序
            int index = i+1;
            while (index < len && nums[index] > leftNum) {
                index++;
            }
            index--;
            swap(nums, i-1, index);
            reverse(nums, i, len-1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {3,2,1};
        nextPermutation.nextPermutation(nums);
    }
}
