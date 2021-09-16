package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        int early = Integer.MAX_VALUE;
        int endest = Integer.MIN_VALUE;

        for (int i = 0; i < trips.length; i++){
            int num = trips[i][0];
            int s = trips[i][1];
            int e = trips[i][2];

            if (!start.containsKey(s)){
                start.put(s, num);
            }else {
                start.replace(s, start.get(s) + num);
            }

            if (!end.containsKey(e)){
                end.put(e, num);
            }else {
                end.replace(e, end.get(e) + num);
            }


            if (early > s){
                early = s;
            }
            if (endest < e){
                endest = e;
            }
        }

        for (int i = early; i <= endest; i++){
            if (end.containsKey(i)){
                capacity += end.get(i);
            }

            if (start.containsKey(i)){
                capacity -= start.get(i);
            }

            if (capacity < 0){
                return false;
            }
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
