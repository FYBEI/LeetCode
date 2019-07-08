package array_and_string.two_dimensional;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();

        if (numRows == 0){
            return tri;
        }

        //先生成各行数组，把头尾设置为1
        for (int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i+1);

            //初始化数组,并固定其长度
            for (int j = 0; j <= i; j++){
                row.add(1);
            }

            tri.add(row);
        }

        //从第三行开始操作
        for (int i = 2; i < numRows; i++){

            //取出前一行和当前行
            List<Integer> pre = tri.get(i-1);
            List<Integer> now = tri.get(i);

            //将上一行的两个数字替换掉当前行对应项
            for (int j = 0; j < pre.size()-1; j++){
                now.set(j+1, pre.get(j) + pre.get(j+1));
            }
        }

        return tri;
    }
}
