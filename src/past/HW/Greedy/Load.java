package past.HW.Greedy;

import java.util.*;

public class Load {

    static int loading(int[] x,  int[] w, int C){
        int n = x.length;
        boolean[] result = new boolean[n];
        int value = 0;

        // 求每一个物品的单位重量
        HashMap<Float, Integer> x_w_rate = new HashMap<>();
        for (int i = 0; i < n; i++){
            x_w_rate.put(((float) x[i])/((float) w[i]), i);
        }

        //将单位重量进行排序，优先放入单位重量大的物品
        List<Float> mapKeys = new ArrayList<Float>(x_w_rate.keySet());
        Collections.sort(mapKeys);

        for (int i = mapKeys.size()-1; i >= 0; i--) {
            float xwr = mapKeys.get(i);

            //id表示第几个物品
            int id = x_w_rate.get(xwr);
            //如果物品重量超过剩余容量，就停止
            if(w[id] > C){
                break;
            }

            //标记存入的物品
            result[id] = true;
            //计算剩余容量
            C -= w[id];
            //计算总价值
            value += x[id];
        }

        return value;
    }

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] x = {6, 3, 5, 4, 5};
        int C = 10;

        int result = loading(x, w, C);
        System.out.println(result);
    }
}
