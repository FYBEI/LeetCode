package past.HW.Dynamic;

public class KnapSack {

    static int knapSack(int[] w, int[] v, int C){
        int num = w.length;
        // V[i][j]代表前i个物品能够装入容量为j的背包的最大值
        int[][] V = new int[num+1][C+1];

        //初始化第0列
        for (int i = 0; i <= num; i++) {
            V[i][0] = 0;
        }
        //初始化第0行
        for (int j = 0; j <= C; j++) {
            V[0][j] = 0;
        }

        for (int i = 1; i <= num; i++){
            for (int j = 1; j <= C; j++){
                if (j < w[i-1]) {
                    //背包容量j < 物品重量w，则前i个物品放入的最大值为前i-1个物品放入的最大值（即这个物品放不下）
                    V[i][j] = V[i-1][j];
                }else {
                    //如果背包放的下，判断前i-1个物品放入的最大值（即不放）和前i-1个物品放入j-w的背包的最大值（即较小背包再扩大），取较大项
                    V[i][j] = Math.max(V[i-1][j], V[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }

        int j = C;
        //记录装入背包的物品
        int[] x = new int[num+1];
        for (int i = num; i > 0; i--){
            if (V[i][j] > V[i-1][j]) {
                // 比前一个物品放入后的价值大，说明放入的物品
                x[i] = 1;
                // 剩余容量
                j = j - w[i-1];
            }else {
                x[i] = 0;
            }
        }

        return V[num][C];
    }

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};

        int C = 10;

        int result = knapSack(w, v, C);
        System.out.println(result);
    }
}
