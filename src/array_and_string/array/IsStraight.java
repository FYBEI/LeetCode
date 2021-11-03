package array_and_string.array;

import java.util.Arrays;

public class IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        // 第一个非0数的位置，大小王数量
        int i = 0;
        int num = 0;
        while (nums[i] == 0){
            i++;
        }
        num = i;

        // 倒序比较，避免出界
        for (int j = nums.length-1; j > i; j--){
            int tmp = nums[j] - nums[j-1] - 1;
            // 如果两个数之间的差值大于num，或者两数重复，返回false
            if (tmp > num || tmp < 0){
                return false;
            }
            // 拿大小王弥补
            num -= tmp;
        }

        return true;
    }
}
