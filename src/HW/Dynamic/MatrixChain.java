package HW.Dynamic;

public class MatrixChain {

    /**
     * 矩阵链连乘
     * @param p
     * @return
     */
    static int matrixChain(int[] p){
        int num = p.length;

        int[][] A = new int[num][num];
        //记录第i到第j的所需的最小次数
        int[][] s = new int[num][num];
        //记录切割位置

        //初始化，对角线为0
        for (int i = 0; i < num; i++){
            A[i][i] = 0;
        }

        //r表示链长，取值2~n
        for (int r = 2; r < num; r++){

            for (int i = 1; i < num-r+1; i++){
                //j依次取值i+1,i+2,……,n
                int j = i + r - 1;
                A[i][j] = A[i+1][j] + p[i-1] * p[i] * p[j];
                //即m[i][j] = m[i][i]+m[i+1][j]+ p[i-1]*p[i]*p[j]
                s[i][j] = i;
                //i为初始断开位置

                //记录最小的次数
                for (int k = i+1; k < j; k++){
                    //依次设断开位置为i+1,i+2,……
                    int t = A[i][k] + A[k+1][j] + p[i-1] * p[k] * p[j];
                    if (t < A[i][j]){
                        A[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }

        for (int i = 0; i < num; i++){
            for (int j = 0; j < num; j++){
                System.out.printf("%6d\t", A[i][j]);
            }
            System.out.println(' ');
        }

        return A[1][num-1];
    }

    public static void main(String[] args) {
        int[] p = {10, 100, 5, 50, 30, 20, 60, 45, 50};
        int result = matrixChain(p);

        System.out.println(result);
    }
}
