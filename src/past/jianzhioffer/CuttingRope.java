package past.jianzhioffer;

import java.util.Arrays;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 解：
 * 1. 将绳子以相等的长度等分为多段 ，得到的乘积最大。
 * 2. 尽可能将绳子以长度 3 等分为多段时，乘积最大。
 *
 * 算法流程：
 * 当 n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1 段，因此必须剪出一段长度为 1 的绳子，即返回 n - 1。
 * 当 n>3 时，求 n 除以 3 的整数部分 a 和余数部分 b （即 n = 3a + b），并分为以下三种情况：
 * 当 b = 0 时，直接返回 3^a % 10000000073
 *
 * 当 b = 1 时，要将一个 1+3 转换为 2+2，因此返回 (3^{a-1} x 4)% 1000000007
 *
 * 当 b = 2 时，返回 (3^a x 2) % 1000000007
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        int max = 0;
        for (int m = 2; m <= n; m++) {
            // 均分后每个数大小和余数
            int len = n/m;
            int rest = n%m;

            // 将余数平均分在每一个数上
            int[] tmp = new int[m];
            Arrays.fill(tmp, len);
            for (int i = 0; i < rest; i++) {
                tmp[i] += 1;
            }

            // 计算当次均分结果
            int res = 1;
            for (int i = 0; i < m; i++) {
                res *= tmp[i];
            }

            if (res > max) {
                max = res;
            }
        }

        return max;
    }

    public int cuttingRope2(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if(b == 0) {
            return (int)(rem * 3 % p);
        }
        if(b == 1) {
            return (int)(rem * 4 % p);
        }
        return (int)(rem * 6 % p);

    }
}
