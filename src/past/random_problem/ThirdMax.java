package past.random_problem;

public class ThirdMax {

    public int thirdMax(int[] nums) {

        // 三个值分别记录了第一大，第二大，第三大
        Long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for (int num:nums){
            if(num == first || num == second || num == third){
                continue;
            }

            if (num > first){
                third = second;
                second = first;
                first = Long.valueOf(num);
            }else if (num > second){
                third = second;
                second = Long.valueOf(num);
            }else if (num > third){
                third = Long.valueOf(num);
            }
        }

        // 第三个值或第二个值都没变时，说明没有第三大的数
        if (third == Long.MIN_VALUE || second == Long.MIN_VALUE){
            return first.intValue();
        }else {
            return third.intValue();
        }
    }

    public static void main(String[] args) {
        ThirdMax tm = new ThirdMax();
        int[] nums = {1, 2, -2147483648};

        tm.thirdMax(nums);
    }
}
