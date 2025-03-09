package past.search.conclude;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 输入：16
 * 输出：True
 *
 * 输入：14
 * 输出：False
 */
public class PerfectSquare {
    public boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1 || num == 4){
            return true;
        }

        long low = 3;
        long high = num/2;

        while (low <= high){

            //设置mid为long型，防止mid*mid超界
            long mid = low + (high - low)/2;

            if (mid*mid == num){
                return true;
            }else if (mid*mid < num){
                low = mid+1;
            }else if (mid*mid > num){
                high = mid-1;
            }
        }

        return false;
    }
}
