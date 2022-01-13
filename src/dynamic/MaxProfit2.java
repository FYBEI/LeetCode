package dynamic;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int ans = 0;
        int maxPrice = prices[n-1];

        // 倒序遍历，寻找连续递增序列
        for (int i = n-2; i >= 0; i--){

            // 当前价格大于最大价格，则计算之前序列的价格差，如果大于0则叠加
//            if (prices[i] > maxPrice){
//                ans += (maxPrice - prices[i+1]);
//                maxPrice = prices[i];
//                continue;
//            }
            // 当前价格大于下一天的价格，则计算之前序列的价格差
            if (prices[i] > prices[i+1]){
                ans += (maxPrice - prices[i+1]);
                maxPrice = prices[i];
                continue;
            }
            // 如果遍历到第一天，则计算第一天到最大价值的价格差
            if (i == 0){
                ans += (maxPrice - prices[i]) > 0 ? (maxPrice - prices[i]) : 0;
            }
        }

        return ans;
    }
}
