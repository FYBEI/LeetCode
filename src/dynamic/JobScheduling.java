package dynamic;

import java.util.Arrays;

public class JobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (x,y) -> (x[1]-y[1]));

        // dp[i] 表示选择任务i的最大利润
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // last为寻找 在任务i开始之前 结束的最后一个任务
            int last = binarySearch(jobs, i);
            // 选择任务i的最大利润
            // 放弃选择任务i，则为dp[i-1]
            // 选择任务i，则为 jobs[i-1] + 选择任务i结束之前最后一共任务的最大利润
            dp[i] = Math.max(dp[i-1], jobs[i-1][2] + dp[last]);
        }

        return dp[n];
    }

    private int getLast(int[][] jobs, int i){
        int last = 0;
        for (int j = i-1; j >= 1; j--){
            if (jobs[j-1][1] <= jobs[i-1][0]){
                last = j;
                break;
            }
        }

        return last;
    }

    private int binarySearch(int[][] jobs, int i){
        int left = 1;
        int right = i-1;

        while (left <= right){
            int mid = (left + right)/2;

            if (jobs[mid-1][1] > jobs[i-1][0]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};

        JobScheduling js = new JobScheduling();
        int max = js.jobScheduling(startTime, endTime, profit);
        System.out.println(max);
    }

}
