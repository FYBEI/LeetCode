package past.jianzhioffer;

public class MovingCount {

    static boolean[][] visit;
    static public int movingCount(int m, int n, int k) {
        visit = new boolean[m][n];
        visit[0][0] = true;

        return 1 + count(m, n, k, 1, 0) + count(m, n, k, 0, 1);
    }

    static public int count(int m, int n, int k, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (visit[i][j]) {
            return 0;
        }
        if (bitSum(i, j) > k) {
            return 0;
        }

        visit[i][j] = true;
        return 1 + count(m, n, k, i-1, j) + count(m, n, k, i+1, j) + count(m, n, k, i, j-1) + count(m, n, k, i, j+1);
    }

    static public int bitSum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i%10;
            i /= 10;
        }
        while (j != 0) {
            sum += j%10;
            j /= 10;
        }

        return sum;
    }

    static public int movingCountDP(int m, int n, int k) {

        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bitSum(i, j) > k) {
                    continue;
                }

                if (i > 0)
                    visit[i][j] |= visit[i-1][j];

                if (j > 0)
                    visit[i][j] |= visit[i][j-1];


                if (visit[i][j])
                    sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 2;
        int k = 1;
        int res = movingCount(m, n, k);
        System.out.println(res);
    }
}
