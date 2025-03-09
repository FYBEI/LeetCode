package past.random_problem;

import java.util.*;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();

        if (n == 1){
            return result;
        }

        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                // 最小公因数为1时为最简分数
                if (gcd(j,i) == 1){
                    result.add(j + "/" + i);
                }
            }
        }

        return result;
    }

    // 化简，取得最小公因数最小公因数
    private int gcd(int a, int b){

        if (b == 0){
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        SimplifiedFractions sf = new SimplifiedFractions();
        int n = 6;

        List<String> result = sf.simplifiedFractions(n);
        System.out.println(result);
    }
}
