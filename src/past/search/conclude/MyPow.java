package past.search.conclude;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }

        if (n == 1){
            return x;
        }

        double tmp = myPow(x, n/2);
        if (n%2 == 0){
            x = tmp*tmp;
        }else {
            if (n < 0){
                x = 1/x*tmp*tmp;
            }else {
                x = x*tmp*tmp;
            }

        }

        return x;
    }
}
