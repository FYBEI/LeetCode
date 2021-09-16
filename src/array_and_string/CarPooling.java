package array_and_string;

import java.util.*;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] roadStation = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            roadStation[trips[i][1]] += trips[i][0];
            roadStation[trips[i][2]] -= trips[i][0];
        }
        int total = 0;
        for (int i = 0; i < 1001; i++) {
            total += roadStation[i];
            if (total > capacity) return false;
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        //创建一个以下车顺序的小根堆
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        //对上车顺序排序
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        for (int[] trip : trips) {
            //先上车
            capacity -= trip[0];
            //车位不够就下车
            if (capacity < 0) {
                while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) capacity += heap.poll()[0];//能下的都下完
                if (capacity < 0) return false;//能下完的 下完还不行就返回
            }
            //加到堆里面
            heap.offer(trip);
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling cp = new CarPooling();

        int[][] trips = {
                {9,3,4},
                {9,1,7},
                {4,2,4},
                {7,4,5}
        };

        int cap = 23;

        boolean res = cp.carPooling(trips, cap);
        System.out.println(res);
    }
}
