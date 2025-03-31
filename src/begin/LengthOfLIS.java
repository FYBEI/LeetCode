package begin;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int res = 1;
        int[] maxLenght = new int[len];
        maxLenght[0] = 1;

        for (int i = 1; i < len; i++) {
            maxLenght[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (maxLenght[j] + 1 > maxLenght[i]) {
                    maxLenght[i] = maxLenght[j] + 1;
                }
            }
            if (maxLenght[i] > res) {
                res = maxLenght[i];
            }
        }

        return res;
    }

    /**
     * DAG：贪心 + 二分
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        // p[i] 的含义是，所有长度为 i+1 的上升子序列的末尾元素中的最小值
        int[] p = new int[len+1];
        int ans = 0;
        p[0] = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            if (nums[i] > p[ans]) {
                ans++;
                p[ans] = nums[i];
            }else if (nums[i] < p[ans]){
                int left = 1;
                int right = ans;
                while (left <= right) {
                    int mid = (left + right)/2;
                    if (p[mid] >= nums[i]) {
                        right = mid-1;
                    }else  {
                        left = mid+1;
                    }
                }
                p[left] = nums[i];
            }
        }

        return ans;
    }
}
