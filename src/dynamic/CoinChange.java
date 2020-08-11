package dynamic;

import java.util.Arrays;

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


    //更好更清晰的算法
    public int coinChange2(int[] coins, int amount) {

        int [] dp=new int [amount+1];
        //初始化将每个硬币的数量最大化到总面值
        Arrays.fill(dp,amount+1);
        //0元的数量为0
        dp[0]=0;

        for(int i=1; i<dp.length; i++)
        {
            for(int coin:coins)
            {
                //所需面值小于当前硬币的面值
                if(i < coin) {
                    continue;
                }

                //当前面值需要的硬币数为，减去当前硬币，之前的硬币数+1（比如6元只需在5元的基础上+1元）
                dp[i]=Math.min(dp[i], dp[i-coin] + 1);

            }
        }

        //如果面值amount的数量仍然为amount+1，说明没有刚好分配的硬币
        return dp[amount]==amount+1? -1:dp[amount];
    }
}
