package past.dynamic;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 硬币数不会超过总钱数
        int max = amount + 1;

        // dp[i]表示总钱数为i时的最小硬币数
        // dp[i] = Min(dp[i], dp[i] - coins[j] + 1)，即是否选择硬币j，选择硬币j后的总钱数为 i-coins[j]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // 如果不存在，则最大一位为amount+1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
