package past.Summary_of_Interview_Problem.math;

import java.util.*;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> vis = new HashSet<>();
        priorityQueue.add(1L);
        vis.add(1L);

        while (!priorityQueue.isEmpty()){

            long num = priorityQueue.poll();
            n--;

            if (n == 0){
                return (int) num;
            }

            if (!vis.contains(num*2)){
                priorityQueue.add(num*2);
                vis.add(num*2);
            }
            if (!vis.contains(num*3)){
                priorityQueue.add(num*3);
                vis.add(num*3);
            }
            if (!vis.contains(num*5)){
                priorityQueue.add(num*5);
                vis.add(num*5);
            }
        }

        return 1;
    }
}
