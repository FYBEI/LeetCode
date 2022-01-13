package slidewindow;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int len = 0;
        int n = nums.length;

        // 设置窗口左右边界
        int i = 0;
        int j = 1;
        // 记录窗口内所有数的总和
        int sum = nums[i];

        for (; j < n; j++){

            // 当 sum >= target，则右移窗口左边界，减少窗口大小
            while(i < j && (sum - nums[i]) >= target){
                sum -= nums[i];
                i++;
            }

            // 更新最短长度，需要判断是否存在最短子序列
            if (sum >= target){
                if (len != 0 && len > j-i){
                    len = j-i;
                }else if (len == 0){
                    len = j-i;
                }
            }

            // 右移右窗口
            sum += nums[j];
        }

        // 右窗口移出数组后，判断sum是否大于target，如果小于，则直接返回
        if (sum < target){
            return len;
        }

        // 确定最短窗口大小
        while (i < j && (sum - nums[i]) >= target){
            sum -= nums[i];
            i++;
        }
        if (len != 0 && len > j-i){
            len = j-i;
        }else if (len == 0){
            len = j-i;
        }

        return len;
    }

    public static void main(String[] args) {
        MinSubArrayLen msal = new MinSubArrayLen();
        int target = 15;
        int[] nums  = {5,1,3,5,10,7,4,9,2,8};

        msal.minSubArrayLen(target, nums);
    }
}
