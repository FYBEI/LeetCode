package array_and_string;

import java.util.*;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 标记当前位置
        int i = 0, j = 0;
        // 标记上下界
        int up, down, left, right;
        // 结果
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        // 初始化边界
        up = -1;
        down = m;
        left = -1;
        right = n;
        // 方向：0为向右走，1为向下走，2为向左走，3为向上走
        int direction = 0;

        while (up < down-1 && left < right-1){
            ans.add(matrix[i][j]);

            // 根据方向移动指针，如果到达边界，则改变方向并更新边界
            if (direction == 0){
                if (j < right-1){
                    j++;
                }else {
                    // 改变方向
                    direction = 1;
                    i++;
                    // 更新边界
                    up++;
                }
            }else if (direction == 1){
                if (i < down-1){
                    i++;
                }else {
                    direction = 2;
                    j--;
                    right--;
                }
            }else if (direction == 2){
                if (j > left+1){
                    j--;
                }else {
                    direction = 3;
                    i--;
                    down--;
                }
            }else if (direction == 3){
                if (i > up+1){
                    i--;
                }else {
                    direction = 0;
                    j++;
                    left++;
                }
            }
        }

        return ans;
    }
}
