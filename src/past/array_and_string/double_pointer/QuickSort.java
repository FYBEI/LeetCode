package past.array_and_string.double_pointer;

public class QuickSort {

    static public void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }

        int i = left, j = right;

        //快速排序
        int tmp = nums[left];
        while (i != j){
            while (nums[j] >= tmp && i < j){
                j--;
            }

            while (nums[i] <= tmp && i < j){
                i++;
            }

            if (i < j){
                int a = nums[i];
                nums[i] = nums[j];
                nums[j] = a;
            }

        }

        nums[left] = nums[i];
        nums[i] = tmp;

        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }

    public static void main(String[] args) {

        int[] nums = {4,2 ,1, 3, 5,1};
        QuickSort.quickSort(nums, 0, nums.length-1);

        for (int i:nums){
            System.out.println(i);
        }
    }
}
