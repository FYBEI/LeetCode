package begin;

public class TrapRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            if (height[i] > leftMax[i-1]) {
                leftMax[i] = height[i];
            }else {
                leftMax[i] = leftMax[i-1];
            }
        }
        rightMax[len-1] = height[len-1];
        for (int i = len - 2; i >= 0; i--) {
            if (height[i] > rightMax[i+1]) {
                rightMax[i] = height[i];
            }else {
                rightMax[i] = rightMax[i+1];
            }
        }

        int res = 0;
        for (int i = 1; i < len-1; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += h;
        }
        return res;
    }
}
