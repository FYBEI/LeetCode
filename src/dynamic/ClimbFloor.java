package dynamic;

/***
 * 爬楼梯，动态规划
 */
public class ClimbFloor {

    public int climb(int n){
        if (n < 1){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }

        int[] tmp = new int[n + 1];
        tmp[0] = 0;
        tmp[1] = 1;
        tmp[2] = 2;

        for (int i = 3; i <= n; i++){
            tmp[i] = tmp[i-2] + tmp[i-1];
        }

        return tmp[n];
    }
}
