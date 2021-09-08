package Summary_of_Interview_Problem.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1){
            return true;
        }

        if (n%3 != 0){
            return false;
        }

        if (n%2 == 0){
            return false;
        }

        return isPowerOfThree(n/3);
    }
}
