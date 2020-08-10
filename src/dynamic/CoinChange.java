package dynamic;

import java.util.Arrays;

public class CoinChange {
    static public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return -1;
        }

        int num = 0;

        Arrays.sort(coins);
        int n = amount/coins[0] + 1;
        int[] tmp = new int[n];
        tmp[0] = coins[0];
        tmp[1] = coins[1];
        tmp[2] = coins[2];

        if (amount != 0){
            return -1;
        }

        return num;
    }
}
