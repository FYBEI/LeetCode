package HW.Recursion;

/**
 * 最优搜索二叉树
 */
public class OptimalBST {

    static double[][] optimalBST(double[] p, double[] q){
        int n = p.length - 1;
        double[][] E = new double[10][10];
        int[][] R = new int[10][10];

        //初始化
        for (int i = 1; i <= n; i++){
            E[i][i-1] = q[i-1];
            E[i][i] = p[i];
            R[i][i] = i;
        }
        E[n+1][n] = 0;

        //按对角线逐条计算
        for (int d = 1; d < n; d++){
            for (int i = 1; i <= n-d; i++){
                int j = i + d;
                double min = Double.MAX_VALUE;
                int mink = i;
                double sum = 0;

                for (int k = i; k <= j; k++){
                    sum = sum + p[k];

                    if (E[i][k-1] + E[k+1][j] < min){
                        min = E[i][k-1] + E[k+1][j];
                        mink = k;
                    }
                }

                E[i][j] = min + sum;
                R[i][j] = mink;
            }
        }

        return E;
    }

    public static void main(String[] args) {
        double[] p = {0.00, 0.15, 0.10, 0.05, 0.10, 0.20};
        double[] q = {0.05, 0.10, 0.05, 0.05, 0.05, 0.10};

        double[][] E = optimalBST(p, q);

        for (int i = 0; i < E.length; i++){
            for (int j = 0; j < E[i].length; j++){
                System.out.printf("%.4f\t", E[i][j]);
            }
            System.out.println(' ');
        }
    }
}
