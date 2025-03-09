package past.random_problem;

public class FindLength {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        FindLength fl = new FindLength();

        int[] nums1 = {1,1,0,0,1};
        int[] nums2 = {1,1,0,0,0};

        fl.findLength(nums1, nums2);
    }
}
