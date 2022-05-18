package MeiTuanPratice;

import java.util.Scanner;

public class ReverseMatrix {

    public int[][] reverse(int n, int m, int[][] nums) {
        if (n <= 0 || m <= 0) {
            return null;
        }

        if (n == m) {
            return reverse(n, nums);
        }

        int[][] res = new int[m][n];
        int min = Math.min(n, m);

        int i, j;
        for (i = 0; i < min; i++) {
            for (j = 0; j < min; j++) {
                res[i][j] = nums[j][i];
            }
        }

        int iBegin = min, jBegin = min;
        if (min < n) {
            iBegin = 0;
        }else {
            jBegin = 0;
        }

        for (i = iBegin; i < m; i++) {
            for (j = jBegin; j < n; j++) {
                res[i][j] = nums[j][i];
            }
        }

        return res;
    }

    private int[][] reverse(int n, int[][] nums) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("input n:");
        int n = sc.nextInt();
        System.out.print("input m:");
        int m = sc.nextInt();

        System.out.print("input matrix:");
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        System.out.println("output matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nums[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        nums = new ReverseMatrix().reverse(n, m, nums);
        System.out.println("output reversed matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
