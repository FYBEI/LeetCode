package HW.HW3;

public class HW3_2 {

    public static float OptBST(float[] P){
        int n = P.length;
        float[][] E = new float[n][n];
        float[][] R = new float[n][n];

        for (int i = 1; i <= n; i++)  //初始化
        {
            E[i][i-1] = P[i-1];
            E[i][i] = P[i];
            R[i][i] = i;
        }
        E[n+1][n]=0;

        for (int d = 1; d < n; d++)     //按对角线逐条计算
            for (int i=1; i <= n-d; i++)
            {
                int j = i + d;
                float min = Float.MAX_VALUE;
                int mink = i;
                float sum = 0;
                for (int k = i; k <= j; k++)
                {
                    sum = sum + P[k];
                    if (E[i][k-1] + E[k+1][j] < min) {
                        min = E[i][k-1] + E[k+1][j];
                        mink=k;
                    }
                }
                E [i][j]=min+sum;
                R[i][j]=mink;
            }

        return E[1][n];
    }

    public static void main(String[] args) {

        float[] P = {(float) 0.05, (float) 0.15, (float) 0.1, (float) 0.1, (float) 0.05, (float) 0.05, (float) 0.05, (float) 0.1, (float) 0.05, (float) 0.2, (float) 0.1};

        System.out.println("输出表达最优二叉排序树形状的矩阵：\n");
        float result = OptBST(P);

        System.out.println(result);

    }
}
