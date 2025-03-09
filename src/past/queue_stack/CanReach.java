package past.queue_stack;

public class CanReach {
    boolean[] vis;

    public boolean canReach(int[] arr, int start) {
        vis = new boolean[arr.length];

        return reach(arr, start);
    }

    private boolean reach(int[] arr, int start) {
        if (start >= arr.length || start < 0){
            return false;
        }

        if (vis[start]){
            return false;
        }

        if (arr[start] == 0){
            return true;
        }

        vis[start] = true;
        boolean next1 = reach(arr, start + arr[start]);
        boolean next2 = reach(arr, start - arr[start]);

        return next1 || next2;
    }
}
