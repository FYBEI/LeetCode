package past.Summary_of_Interview_Problem.math;

public class ReverseInt {
    public int reverse(int x) {
        if (x > 0){
            return reverseInt(x);
        }else if (x < 0){
            return -reverseInt(-x);
        }else {
            return 0;
        }
    }

    private int reverseInt(int x) {
        int ans = 0;
        while (x > 0){
            // 获得最后一位
            int tmp = x%10;
            x /= 10;

            // 超出整型范围
            if ((long) ans*10 + tmp > Integer.MAX_VALUE){
                return 0;
            }

            ans = ans*10 + tmp;
        }

        return ans;
    }
}
