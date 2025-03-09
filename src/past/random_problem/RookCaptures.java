package past.random_problem;

public class RookCaptures {
    public int numRookCaptures(char[][] board) {

        int num = 0;

        // 初始话R的位置
        int row = -1;
        int col = -1;

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (board[i][j] == 'R'){
                    row = i;
                    col = j;
                    break;
                }
            }

            if (row != -1){
                break;
            }
        }

        // 在固定行上寻找可捕捉的p
        for (int i = col + 1; i < 8; i++){
            if (board[row][i] == 'p'){
                num++;
                break;
            }else if (board[row][i] == 'B'){
                break;
            }
        }

        for (int i = col - 1; i >= 0; i--){
            if (board[row][i] == 'p'){
                num++;
                break;
            }else if (board[row][i] == 'B'){
                break;
            }
        }

        // 在固定列寻找可捕捉的p
        for (int i = row + 1; i < 8; i++){
            if (board[i][col] == 'p'){
                num++;
                break;
            }else if (board[i][col] == 'B'){
                break;
            }
        }

        for (int i = row - 1; i >= 0; i--){
            if (board[i][col] == 'p'){
                num++;
                break;
            }else if (board[i][col] == 'B'){
                break;
            }
        }

        return num;
    }
}
