package past.random_problem;

public class Trap {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap t = new Trap();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = t.trap(height);
        System.out.println(ans);
    }
}
