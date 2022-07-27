package jianzhioffer;

public class SingleNumbers {

    public static int[] singleNumbers(int[] nums) {

        // 对所有数进行异或运算，结果为两个出现一次的数字的异或
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }

        // 寻找结果为1的位，说明这一位可以将数字分为两组，并且两个出现一次的数字分别在两个组中
        // 因为异或计算中，相同的为0，不同的为1，会出现为1的位，说明两个数字在这一位不同
        // 剩余的数字无论被分到哪一组，最终都会被异或计算消除
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        singleNumbers(nums);
    }
}
