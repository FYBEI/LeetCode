package past.queue_stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CanReach {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vis[start] = true;

        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++){
                int pos = queue.poll();

                if (arr[pos] == 0){
                    return true;
                }

                if (pos + arr[pos] < arr.length && !vis[pos + arr[pos]]){
                    vis[pos + arr[pos]] = true;
                    queue.add(pos + arr[pos]);
                }
                if (pos - arr[pos] >= 0 && !vis[pos - arr[pos]]){
                    vis[pos - arr[pos]] = true;
                    queue.add(pos - arr[pos]);
                }
            }
        }

        return false;
    }
}
