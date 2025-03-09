package past.dynamic;

/**
 * 最大连续子串
 */
public class MaxSubArray {

    public int max(int a, int b){
        return a>b?a:b;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }else if (len == 1){
            return nums[0];
        }

        int[] tmp = new int[len];
        tmp[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < len; i++){
            tmp[i] = max(nums[i], nums[i] + tmp[i-1]);
            if (max < tmp[i]){
                max = tmp[i];
            }
        }

        return max;
    }
}
