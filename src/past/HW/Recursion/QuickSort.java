package past.HW.Recursion;

public class QuickSort {

    static void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }

        int i = left, j = right;

        //快速排序
        int tmp = nums[left];

        //将<tmp的数交换到左边
        //将>tmp的数交换到右边
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

        quickSort(nums, left, i-1); //快速排序左半段
        quickSort(nums, i+1, right);    //快速排序右半段
    }
}
