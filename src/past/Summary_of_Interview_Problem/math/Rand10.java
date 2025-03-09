package past.Summary_of_Interview_Problem.math;

import java.util.Random;

public class Rand10 {
    public int rand7(){
        Random random = new Random();
        int r = random.nextInt(6) + 1;
        return r;
    }

    // 拒绝采样
    public int rand10(){
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 40) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 40;
            b = rand7();
            // get uniform dist from 1 - 63
            idx = b + (a - 1) * 7;
            if (idx <= 60) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 60;
            b = rand7();
            // get uniform dist from 1 - 21
            idx = b + (a - 1) * 7;
            if (idx <= 20) {
                return 1 + (idx - 1) % 10;
            }
        }
    }

    /**古典概型
     1. 第一次rand7限定[1,6]，判断奇偶性，概率是1/2
     2. 第二次rand7限定[1,5]，概率是1/5
     3. 二者结合可以得出10种概率相同的结果
     */
    public int rand10_classic(){
        int first, second;
        while ((first = rand7()) > 6);
        while ((second = rand7()) > 5);
        return (first&1) == 1 ? second : 5+second;
    }
}

