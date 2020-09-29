package dynamic;

public class LengthOfLIS {
    static public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }else if (len == 1){
            return 1;
        }

        int[] dp = new int[len + 1];
        for(int i = 0; i < len + 1; i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[1] = nums[0];

        int p = 1;

        for (int i = 1; i < len; i++){
            if (nums[i] > dp[p]){
                dp[++p] = nums[i];
            }else {
                int index = indexOfFirstBigger(dp, nums[i], 0, p);
                if (index != -1){
                    dp[index] = nums[i];
                }
            }
        }

        return p;
    }

    public static int indexOfFirstBigger(int[] dp, int v, int l, int r){
        while (l <= r){
            int mid = (l + r)/2;
            if (dp[mid] >= v){
                r = mid;
            }else {
                l = mid + 1;
            }

            if (l == r && dp[l] >= v){
                return l;
            }
        }

        return -1;
    }
}
