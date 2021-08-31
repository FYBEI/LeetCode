package random_problem;

/**
 * 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
 * 剩下的乘客将会：
 * 如果他们自己的座位还空着，就坐到自己的座位上，
 * 当他们自己的座位被占用时，随机选择其他座位
 * 第 n 位乘客坐在自己的座位上的概率是多少？
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：1.00000
 * 解释：第一个人只会坐在自己的位置上。
 *
 * 示例 2：
 * 输入: n = 2
 * 输出: 0.50000
 * 解释：在第一个人选好座位坐下后，第二个人坐在自己的座位上的概率是 0.5。
 */
public class NthPersonGetsNthSeat {

    /**
     * 动态规划的思想：f(n)为n个人时的概率
     *
     * 当第 1位乘客选择第 1个座位时，第 n位乘客坐在自己的座位上的概率是 1.0。
     * 当第 1位乘客选择第 n个座位时，第 n位乘客坐在自己的座位上的概率是 0.0。
     * 当第 1位乘客选择其他座位时，其余 n-1位乘客中有一位乘客的座位被占用，需要随机选择其他座位，因此问题规模从 n减小至 n-1。
     *
     * f(n) = 1/n * 1 + 1/n * 0 + n-2/n * f(n-1)
     */
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1){
            return 1;
        }

        return 0.5;
    }

    public static void main(String[] args) {
        NthPersonGetsNthSeat n = new NthPersonGetsNthSeat();

        double result = n.nthPersonGetsNthSeat(4);
        System.out.println(result);
    }
}
