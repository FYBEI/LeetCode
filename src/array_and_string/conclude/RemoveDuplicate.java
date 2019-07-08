package array_and_string.conclude;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        //i标记重复数字的第一个和不重复数字
        int i = 0;
        //j标记重复数字
        int j = 1;

        while (j < nums.length){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i+1;
    }
}
