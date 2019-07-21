package search.model1;


/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 输入: 4
 * 输出: 2
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    //利用递归的二分法
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        } else {
            return sqrt(x, 2, x);
        }
    }

    private int sqrt(int data, int low, int high) {
        if(low > high){
            return high;
        }

        int mid = low + ((high - low) >> 1);
        if (mid > data / mid) {
            return sqrt(data, low, mid - 1);
        } else if (mid < data / mid) {
            return sqrt(data, mid + 1, high);
        } else {
            return mid;
        }
    }

    public int mySqrt2(int x) {

        //46340是int型的最大的平方根
        int n = Math.min(x, 46340);
        while (n * n > x) {
            n = (n + x / n) / 2;
        }
        return n;
    }
}
