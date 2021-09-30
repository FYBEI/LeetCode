package dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class PileBox {
    public int pileBox(int[][] box) {
        Arrays.sort(box,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] > o2[0]){
                            return 1;
                        }else if (o1[0] == o2[0]){
                            if (o1[1] > o2[1]){
                                return 1;
                            }else if (o1[1] == o2[1]){
                                if (o1[2] > o2[2]){
                                    return 1;
                                }
                            }
                        }

                        return -1;
                    }
                });

        int[] dp = new int[box.length];

        for (int i = 0; i < box.length; i++){
            dp[i] = box[i][2];
        }

        for (int i = 0; i < box.length; i++){
            for (int j = 0; j < i; j++){
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]){
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++){
            if (dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }
}
