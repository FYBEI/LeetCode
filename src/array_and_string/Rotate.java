package array_and_string;

public class Rotate {
    boolean[][] visit;

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 1){
            return;
        }
        visit = new boolean[m][m];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                change(matrix, j, m-i-1, matrix[i][j]);
            }
        }
    }

    private void change(int[][] matrix, int i, int j, int next){
        if (visit[i][j]){
            return;
        }

        visit[i][j] = true;
        int tmp = matrix[i][j];
        matrix[i][j] = next;
        next = tmp;

        change(matrix, j, matrix.length-i-1, next);
    }

}
