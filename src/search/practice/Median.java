package search.practice;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0){
            if (nums2.length % 2 == 0){
                return (nums2[nums2.length/2]+nums2[nums2.length/2 - 1])/2;
            }else {
                return nums2[nums2.length/2];
            }
        }

        if (nums2 == null || nums2.length == 0){
            if (nums1.length % 2 == 0){
                return (nums1[nums1.length/2]+nums1[nums1.length/2 - 1])/2;
            }else {
                return nums1[nums1.length/2];
            }
        }

        double[] nums = new double[nums1.length+nums2.length];
        int a1 = 0;
        int a2 = 0;
        int i = 0;

        while (a1 < nums1.length && a2 < nums2.length){
            if (nums1[a1] <= nums2[a2]){
                nums[i] = nums1[a1];
                a1++;
            }else {
                nums[i] = nums2[a2];
                a2++;
            }

            i++;
        }

        while (a1 < nums1.length){
            nums[i] = nums1[a1];
            a1++;
            i++;
        }

        while (a2 < nums2.length){
            nums[i] = nums2[a2];
            a2++;
            i++;
        }

        if (nums.length%2 == 0){
            return (nums[nums.length/2]+nums[nums.length/2 - 1])/2;
        }else {
            return nums[nums.length/2];
        }

    }

    /**
     * leetcode上最快的答案
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //另nums1为较短的那一个，nums2为较长的那一个（即如果一个为空就设置nums1为空的那个）
        if (m > n) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
            m = nums1.length;
            n = nums2.length;
        }

        if (m == 0) {
            return (nums2[n / 2] + nums2[(n - 1) / 2]) / 2.0;
        }

        //设置指针，nums1的第一位和最后一位分别时最小和最大项
        int imax = m;
        int imin = 0;
        int i = 0, j = n / 2;
        while (imin < imax) {

            //i指向nums1的中间，j指向nums2的中间偏后一个单位
            i = (imax + imin) / 2;
            j = (m + n) / 2 - i;

            //判断nums2中间偏后的数字在nums1中的位置
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i;
            } else if (j > 0 && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else {
                break;
            }
        }

        if (imin == imax) {
            i = (imax + imin) / 2;
            j = (m + n) / 2 - i;
        }

        // System.out.println(i + " " + j);


        if ((m + n) % 2 == 1) {
            if (i == m) {
                return nums2[j];
            } else {
                return Integer.min(nums1[i], nums2[j]);
            }
        }

        if (i == 0) {
            if (j == n) {
                return (nums1[i] + nums2[j - 1]) / 2.0;
            }
            return (Integer.min(nums1[i], nums2[j]) + nums2[j - 1]) / 2.0;
        } else if (i == m) {
            if (j == 0) {
                return (nums1[i - 1] + nums2[j]) / 2.0;
            }
            return (Integer.max(nums1[i - 1], nums2[j - 1]) + nums2[j]) / 2.0;
        } else {
            return (Integer.max(nums1[i - 1], nums2[j - 1]) + Integer.min(nums1[i], nums2[j])) / 2.0;
        }
    }
}
