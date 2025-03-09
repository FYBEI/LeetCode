package past.array_and_string.double_pointer.tow;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        //one表示1的位置，zero表示0的位置
        int one = 0;
        int zero = 0;

        //两个while顺序不可调换
        for (int i = 0; i < nums.length; i++){
            //先移动0的位置
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            zero = i;

            //再移动1的位置
            while (i < nums.length && nums[i] == 1){
                i++;
            }
            one = i;

            //计算连续1的长度
            int num = one - zero;
            if (num > max){
                max = num;
            }

        }

        return max;
    }
}
