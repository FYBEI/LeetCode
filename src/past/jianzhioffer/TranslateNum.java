package past.jianzhioffer;

public class TranslateNum {
    static int count = 0;

    static public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }else if (num <= 25) {
            return 2;
        }

        // 用数组形式表示每一位数
        int[] nums = new int[10];
        int len = 0;
        int tmp = num;
        while (tmp != 0) {
            nums[len] = tmp%10;
            tmp /= 10;
            len++;
        }

        count(nums, len-1);
        System.out.println(count);

        return count;
    }

    static public void count(int[] nums, int index) {
        int i = index;
        for ( ; i >= 0; i--) {

            // 如果当前不为最后一位，或者当前为不为0（因为两位数不能以0起始）
            if (i > 0 && nums[i] != 0) {
                // 计算合体的两位数大小时候可以表示，可以表示则递归
                int n = nums[i]*10 + nums[i-1];
                if (n <= 25) {
                    count(nums, i-2);
                }
            }
        }

        // 每遍历完一次就计数+1
        if (i == -1) {
            count++;
        }
    }

    /**
     * 12258
     * 1,2,2,5,8
     * 12,2,5,8
     * 1,22,5,8
     * 1,2,25,8
     * 12,25,8
     *
     * 235611
     * 2,3,5,6,1,1
     * 23,5,6,1,1
     * 2,3,5,6,11
     * 23,5,6,11
     */
    public static void main(String[] args) {
        translateNum(201);
    }
}
