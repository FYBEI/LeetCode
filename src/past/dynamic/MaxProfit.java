package past.dynamic;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int ans = 0;
        int maxPrice = prices[n-1];

        for (int i = n-2; i >= 0; i--){
            if (prices[i] >= maxPrice){
                maxPrice = prices[i];
            }else {
                if (ans < maxPrice - prices[i]){
                    ans = maxPrice - prices[i];
                }
            }
        }

        return ans;
    }
}
