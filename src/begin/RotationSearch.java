package begin;

public class RotationSearch {

    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public static int search(int[] nums, int l, int r, int target) {
        if (r < l) {
            return -1;
        }

        // 同时比较两端和中间，快速过滤
        if(nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        int mid = (r+l)/2;
        if (nums[mid] == target) {
            return mid;
        }

        // 值在l和mid范围内，说明l到mid中间是递增的，则一定在此之间
        if (nums[l] < target && target < nums[mid]) {
            return search(nums, l+1, mid-1, target);
        }
        // 值在mid和r范围内，说明mid到r中间是递增的，则一定在此之间
        if (nums[mid] < target && target < nums[r]) {
            return search(nums, mid+1, r-1, target);
        }

        // 其余情况难以确定在左或右，则两端都搜索
        int lv = search(nums, l+1, mid-1, target);
        if (lv != -1) {
            return lv;
        }
        return search(nums, mid+1, r-1, target);
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
