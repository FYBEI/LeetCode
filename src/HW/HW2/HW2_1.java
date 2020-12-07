package HW.HW2;

public class HW2_1 {

    static void matrixChainMultiplication(int[] p){
        int n = p.length;

        int q;
        int[][] min = new int[n][n];
        int[][] s = new int[n][n];

        for (int l = 2; l < n; l++){
            //l表示链长

            for (int i = 1; i < n-l+1; i++){

                int j = i + l - 1;
                min[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    q = min[i][k] + min[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < min[i][j]){
                        min[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            for (int j = i + 1; j < n; j++){
                System.out.printf("%6d\t", min[i][j]);

                if(result > min[i][j])
                    result = min[i][j];
            }
            System.out.println(' ');
        }

        System.out.print("计算次数：");
        System.out.println(result);
        print_chain(s, 1, n-1);
    }

    static void print_chain(int[][] s, int i, int j){
        if (i == j){
            System.out.print('A');
            System.out.print(i);
        }else {
            System.out.print('(');
            print_chain(s, i, s[i][j]);
            print_chain(s, s[i][j]+1, j);
            System.out.print(')');
        }
    }

    public static void main(String[] args) {

        int[] p = {10, 100, 5, 50, 30, 20, 60, 45, 50};
        HW2_1.matrixChainMultiplication(p);
    }
}
