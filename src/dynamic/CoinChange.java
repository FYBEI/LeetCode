package dynamic;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * rem钱时所需的最小数量
     * @param coins
     * @param rem   剩余钱数
     * @param count 存储不同面额的硬币的数量
     * @return
     */
    private int coinChange(int[] coins, int rem, int[] count) {
        //剩余钱数小于0说明无法刚好分配
        if (rem < 0) {
            return -1;
        }
        //剩余钱数等于0说明不用分配
        if (rem == 0) {
            return 0;
        }
        //最大面额的数量不为0的话，选择最大面额的分配的数量
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        //初始化最小数量为无穷，暗示无限个硬币
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            //使用其中一个coin后，剩余rem-coin，所需的最小数量
            int res = coinChange(coins, rem - coin, count);
            //如果该最小数量比0大，比现在的最小小，就替换
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        //如果最小还是无限，取该值为-1，说明无法刚好分配
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
