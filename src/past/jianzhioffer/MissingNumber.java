package past.jianzhioffer;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        if (nums[len-1] == len-1) {
            return len;
        }

        int left = 0;
        int right = len-1;
        int mid = (left + right)/2;

        while (left < right) {
            if (mid == nums[mid]) {
                left = mid+1;
            }else {
                right = mid-1;
            }

            mid = (left+right)/2;
        }

        return left;
    }
}
