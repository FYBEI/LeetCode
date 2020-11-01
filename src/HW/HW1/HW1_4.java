package HW.HW1;

import java.util.Random;
import java.util.Scanner;

public class HW1_4 {

    public int[][] board;
    public int dr, dc, size;
    private int t;

    public HW1_4(int size) {
        this.size = size;
        this.board = new int[size][size];
        //随机生成特殊方格
        Random random = new Random();
        this.dr = random.nextInt(size);
        this.dc = random.nextInt(size);
        this.t = 0;
    }

    public void chessboard(){
        chessboard(0, 0, dr, dc, size);
    }

    /**
     * @param tr 棋盘左上角方格行标
     * @param tc 棋盘左上角方格列标
     * @param dr 特殊方块的行标
     * @param dc 特殊方块的列标
     * @param size 棋盘边长
     */
    private void chessboard(int tr, int tc, int dr, int dc, int size){
        if (size <= 1){
            return;
        }

        int s = size/2;

        //特殊方块在左上角
        if (dr <= tr + s - 1 && dc <= tc + s - 1){
            t++;
            board[tr+s-1][tc+s] = t;
            board[tr+s][tc+s] = t;
            board[tr+s][tc+s-1] = t;
            //左上
            chessboard(tr, tc, dr, dc, s);
            //右上
            chessboard(tr, tc+s, tr+s-1, tc+s, s);
            //右下
            chessboard(tr+s, tc+s, tr+s, tc+s, s);
            //左下
            chessboard(tr+s, tc, tr+s, tc+s-1, s);
        }

        //特殊方块在右上角
        if (dr <= tr + s - 1 && dc > tc + s - 1){
            t++;
            board[tr+s-1][tc+s-1] = t;
            board[tr+s][tc+s-1] = t;
            board[tr+s][tc+s] = t;
            //右上
            chessboard(tr, tc+s, dr, dc, s);
            //左上
            chessboard(tr, tc, tr+s-1, tc+s-1, s);
            //左下
            chessboard(tr+s, tc, tr+s, tc+s-1, s);
            //右下
            chessboard(tr+s, tc+s, tr+s, tc+s, s);
        }

        //特殊方块在左下角
        if (dr > tr + s -1 && dc <= tc + s - 1){
            t++;
            board[tr+s-1][tc+s-1] = t;
            board[tr+s-1][tc+s] = t;
            board[tr+s][tc+s] = t;
            //左下
            chessboard(tr+s, tc, dr, dc, s);
            //左上
            chessboard(tr, tc, tr+s-1, tc+s-1, s);
            //右上
            chessboard(tr, tc+s, tr+s-1, tc+s, s);
            //右下
            chessboard(tr+s, tc+s, tr+s, tc+s, s);
        }

        //特殊方块在右下角
        if (dr > tr + s - 1 && dc > tc + s - 1){
            t++;
            board[tr+s][tc+s-1] = t;
            board[tr+s-1][tc+s-1] = t;
            board[tr+s-1][tc+s] = t;
            //右下
            chessboard(tr+s, tc+s, dr, dc, s);
            //左下
            chessboard(tr+s, tc, tr+s, tc+s-1, s);
            //左上
            chessboard(tr, tc, tr+s-1, tc+s-1, s);
            //右上
            chessboard(tr, tc+s, tr+s-1, tc+s, s);
        }

    }

    /**
     * 棋盘覆盖测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("输入k：");
        int k = new Scanner(System.in).nextInt();

        HW1_4 hw1_4 = new HW1_4((int) Math.pow(2, k));
        hw1_4.chessboard();

        int[][] board = hw1_4.board;
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.printf("%4d", board[i][j]);
            }
            System.out.print('\n');
        }
    }
}
