package HW.HW3;

public class HW3_2 {

    //接受一个中序序列的点的查找概率数组，返回最优的二叉查找树的代价（注意P中的概率按顺序对应于点的中序序列）
    public static int[][] OptBST(float[] P){

        int n = P.length; //结点个数
        float[][] result = new float[n][n];

        int[][] R = new int[n][n]; //表达二叉查找树形状的矩阵

        for(int i = 0; i < n; i++) {
            result[i][i] = P[i]; //填充主对角线C[i,i] = P[i]
            R[i][i] = i; //R[i][j]表示若只构造从i到j的树，那么root是R[i][j]
        }

        for(int d = 1; d <= n - 1; d++) {
            //共n-1条对角线需要填充

            for(int i = 0; i <= n - d - 1; i++) {
                //横坐标的范围与对角线编号d的关系

                int j = i + d; //一旦横坐标确定后，纵坐标可以用横坐标与对角线编号表示出来
                float min = Integer.MAX_VALUE;

                int root = 0;

                for(int k = i; k <= j; k++) {

                    float C1 = 0, C2 = 0; //用C1，C2表示result[i,k-1]和result[k+1,j]
                    if(k > i)
                        C1 = result[i][k - 1];
                    if(k < j)
                        C2 = result[k + 1][j];

                    if(C1 + C2 < min) {
                        min = C1 + C2;
                        root = k;
                    }
                }

                R[i][j] = root; //R[i][j]的值代表从i到j的最优二叉查找树的根

                float sum = 0;
                for(int s = i; s <= j; s++)
                    sum = sum + P[s];

                result[i][j] = sum + min;
            }
        }

        //return result[0][n-1]; //返回C[1,n],最小代价
        return R; //返回表达最优二叉排序树形状的矩阵
    }

    public static void main(String[] args) {

        float[] P = {(float) 0.05, (float) 0.15, (float) 0.1, (float) 0.1, (float) 0.05, (float) 0.05, (float) 0.05, (float) 0.1, (float) 0.05, (float) 0.2, (float) 0.1};

        //若返回值是最小代价，测试最小代价是否正确
        //System.out.println("输出最优二叉排序树的最小代价：\n");
        //float result = OptBST(P);
        //System.out.println(result);

        //若返回值是表达最优二叉排序树形状的矩阵，测试矩阵是否正确
        System.out.println("输出表达最优二叉排序树形状的矩阵：\n");
        int[][] R = OptBST(P);
        for(int i = 0; i < R.length; i++) {

            for(int j = 0; j < R.length; j++)
                System.out.print(R[i][j] + "　　");

            System.out.println();
        }

    }
}
