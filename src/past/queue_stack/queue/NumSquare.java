package past.queue_stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquare {

    /**
     * 使用bfs实现
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n == 0){
            return 0;
        }

        int num = 0;
        int tempSize, tempValue = 0;

        //queue存储每次计算过后剩余量，初始即为n
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()){
            tempSize = queue.size();

            //依次取出不同情况的剩余值
            for (int i = 0; i < tempSize; i++){
                tempValue = queue.poll();

                //获得小于改剩余值的所有平方值
                for (int j = (int) Math.sqrt(tempValue); j > 0; --j){

                    //如果剩余值刚好等于j*j，放回次数，否则将该减去该平方值后的新的剩余值加入queue
                    if (tempValue == j*j){
                        return num + 1;
                    }else {
                        queue.add(tempValue - j*j);
                    }
                }
            }

            //对所有剩余值处理完后，次数+1
            num += 1;
        }

        return num;
    }

    /**
     * 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
     * 推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)
     * @param n
     * @return
     */
    public int numSquares2(int n){
        //先根据上面提到的公式来缩小n
        while(n % 4 == 0) {
            n /= 4;
        }

        //如果满足公式 则返回4
        if(n % 8 == 7) {
            return 4;
        }

        //在判断缩小后的数是否可以由一个数的平方或者两个数平方的和组成
        int a = 0;
        while ((a * a) <= n) {
            int b = (int) Math.sqrt((n - a * a));
            if(a * a + b * b == n) {
                //如果可以 在这里返回
                if(a != 0 && b != 0) {
                    return 2;
                } else{
                    return 1;
                }
            }
            a++;
        }

        //如果不行 返回3
        return 3;
    }

    /**
     * 动态规划dp
     * @param n
     * @return
     */
    public int numSquares3(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
