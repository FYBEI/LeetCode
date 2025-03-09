package past.array_and_string.conclude;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowI = new ArrayList<>(rowIndex + 1);

        //第一行和第二行直接返回[1]和[1,1]
        rowI.add(1);
        if (rowIndex == 0){
            return rowI;
        }

        rowI.add(1);
        if (rowIndex == 1){
            return rowI;
        }

        //第三行开始，每一行比前一行多1个，且中间n-1个为上一行n个两两相加的值
        for (int i = 2; i <= rowIndex; i++){

            //j从第二个元素开始
            int j = 1;

            //tmp表示当前元素和前一个元素的和，next表示当前元素和下一个元素的和
            int tmp = 0;
            int nextTmp = 0;

            while (j < i){

                //如果存在nextTmp，tmp = nextTmp，否则计算tmp（适用于每行的起始位置）
                if (nextTmp == 0){
                    tmp = rowI.get(j-1) + rowI.get(j);
                }else {
                    tmp = nextTmp;
                }


                //如果j没有过界，计算下一项之和，否则下一项之和为0，用tmp替换当前项
                if (j+1 < i){
                    nextTmp = rowI.get(j) + rowI.get(j+1);
                    rowI.set(j, tmp);
                }else {
                    nextTmp = 0;
                    rowI.set(j, tmp);
                }

                j++;
            }

            rowI.add(1);
        }


        return rowI;
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
}
