package jianzhioffer;

/**
 * 只含质因子2，3，5的数
 */
public class NthUglyNumber {
    static public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n-1;
        }

        int[] unums = new int[n];
        unums[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < n; i++) {
            int next2 = unums[index2] * 2;
            int next3 = unums[index3] * 3;
            int next5 = unums[index5] * 5;

            int min = Math.min(next2, Math.min(next3, next5));
            if (min == next2) {
                index2++;
            }
            if (min == next3) {
                index3++;
            }
            if (min == next5) {
                index5++;
            }
            unums[i] = min;
        }

        return unums[n-1];
    }

    public static void main(String[] args) {
        int n = 10;
        int res = nthUglyNumber(n);
        System.out.println(res);
    }
}
