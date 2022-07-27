package dynamic;

public class Jump2 {

    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i = 0; i < length - 1; i++) {
            // 当前位置可以走到的最远距离
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达边界时，更新边界并跳跃次数增加1
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        int res = jump(nums);
        System.out.println(res);
    }
}
