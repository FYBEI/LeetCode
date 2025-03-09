package past.dynamic;

public class Thief {
    public int rob(int[] nums) {
        int money = 0;
        int n = nums.length;
        if (n == 0){
            return 0;
        }else if (n == 1){
            return nums[0];
        }else if (n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] tmp = new int[n];
        tmp[0] = nums[0];
        tmp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++){
            tmp[i] = Math.max(tmp[i-1], tmp[i-2] + nums[i]);
        }
        money = tmp[n-1];

        return money;
    }
}
