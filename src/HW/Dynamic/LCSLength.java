package HW.Dynamic;

public class LCSLength {

    /**
     * 最长公共子序列
     * @param x
     * @param y
     * @return
     */
    static int lcsLength(char[] x, char[] y){
        int x_len = x.length;
        int y_len = y.length;

        //c记录序列和的最长公共子序列的长度
        int[][] c = new int[x_len+1][y_len+1];
        int[][] b = new int[x_len+1][y_len+1];

        //i=0或j=0时，说明为空字符串
        for (int i = 0; i <= x_len; i++){
            c[i][0] = 0;
        }
        for (int i = 0; i <= y_len; i++){
            c[0][i] = 0;
        }

        for (int i = 1; i <= x_len; i++){
            for (int j = 1; j <= y_len; j++){

                if (x[i-1] == y[j-1]){
                    //相同的字符，则在前一个状态（a少一个字符和b少一个字符）长度加1
                    //即等于左上角+1
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }else if(c[i-1][j] >= c[i][j-1]){
                    //遇见不同的字符，则为前一个状态（a少一个字符或者b少一个字符）中较长的一个长度
                    //即等于左边和上变较大的一个
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }

        for (int i = 0; i <= x_len; i++){
            for (int j = 0; j <= y_len; j++){
                System.out.printf("%3d\t", c[i][j]);
            }
            System.out.println(' ');
        }

        return c[x_len][y_len];
    }

    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] b = {'B', 'D', 'C', 'A', 'B', 'A'};

        int result = lcsLength(a, b);
        System.out.print(result);
    }
}
