package past.array_and_string;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int i = 0;
        int j = 0;

        int[][] result = new int[n][n];

        // 指示方向，0为向右，1为向下，2为向左，3为向上
        int direction = 0;
        // 指示边界
        int left = 0, right = n-1, up = 0, down = n-1;
        for (; num <= n*n; num++){
            result[i][j] = num;

            switch (direction) {
                case 0:
                    if (j < right){
                        j++;
                    }else {
                        i++;
                        up++;
                        direction = 1;
                    }
                    break;
                case 1:
                    if (i < down){
                        i++;
                    }else {
                        j--;
                        right--;
                        direction = 2;
                    }
                    break;
                case 2:
                    if (j > left){
                        j--;
                    }else {
                        i--;
                        down--;
                        direction = 3;
                    }
                    break;
                case 3:
                    if (i > up){
                        i--;
                    }else {
                        j++;
                        left++;
                        direction = 0;
                    }
                    break;
            }
        }

        return result;
    }
}
