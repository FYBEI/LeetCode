package jianzhioffer;

public class FindNumberIn2DArray {
    static public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int m = matrix.length;
        if(m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }

        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                };


        boolean res = findNumberIn2DArray(nums, 18);
        System.out.println(res);
    }
}
