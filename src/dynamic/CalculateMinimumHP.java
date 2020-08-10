package dynamic;

import java.util.Arrays;

/**
 * 思路：逆向思考，从右下往左上计算
 *
 * 题目所计算的初始hp，既要考虑在途中避免hp<0，还要考虑在最终结果上hp<0
 * 当开始的部分出现多个负数，即使后期全是正数，为了hp不在中途为负，保证初始值够大
 * 当整条路径的正数和小于负数和时，又要考虑到初始值在最终不为负
 * 所以，在动态规划时既要考虑初始hp，又要考虑实时hp，在路径中间出现的正数会影响到后期遇见负数的决策（即，前期的初始hp很大，但是正数过大而使中途hp很高）
 *
 * 从逆向出发，tmp[i][j]代表从[i,j]到终点的距离，tmp[i][j]的计算为tmp[i+1][j]或tmp[i][j+1]-dungeon[i][j](即往上回退，或往左回退)
 * 每次选取前一个最小距离，计算的结果需和1比较：
 * 如果dungeon[i][j]为负数，说明在此之前需要的hp很高；如果dungeon[i][j]为正数且计算结果小于1，说明在中途出现了一个很大的正数，将后期的负数效果抵消，所以之前的hp只需维持最小的1即可
 * 最终计算结果为tmp[0][0]
 */
public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int minHp;
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] tmp = new int[m+1][n+1];
        //初始化边界部分，用于计算tmp[m-1][]和tmp[][n-1]
        for (int i = 0; i <= m; ++i) {
            //由于tmp[m][]和tmp[][n]都为无效值，全部设为最大值
            Arrays.fill(tmp[i], Integer.MAX_VALUE);
        }
        //代表最终剩余的hp至少为1
        tmp[m][n-1] = tmp[m-1][n] = 1;

        for (int i = m-1; i >= 0; i--){
            for (int j = n-1; j>= 0; j--){
                tmp[i][j] = Math.max(Math.min(tmp[i+1][j], tmp[i][j+1]) - dungeon[i][j] , 1);
            }
        }
        minHp = tmp[0][0];

        return minHp;
    }
}
