package Summary_of_Interview_Problem;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 */
public class Merge {

    /**
     * 双指针，指针从前往后，需要在时间和空间中取舍，即是用额外空间保存需要移动的元素，还是用额外的时间先移动这些元素
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }else if (m == 0){
            for (int j = 0; j < n; j++){
                nums1[j] = nums2[j];
            }
            return;
        }

        int i = 0;  //标记nums1
        int j = 0;  //标记nums2

        while (i < m && j < n){
            // 如果nums[i] <= nums2[j], i指针向后移动
            if (nums1[i] <= nums2[j]){
                i++;
            }else {

                // 否则将要插入地方之后的元素移动，再插入
                for (int x = m; x > i; x--){
                    nums1[x] = nums1[x-1];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }
        }

        // 如果还剩更大的元素没有插入，遍历插入
        while (j < n){
            nums1[i++] = nums2[j++];
        }

        for (int index = 0; index < nums1.length; index++){
            System.out.println(nums1[index]);
        }
    }

    /**
     * 双指针，指针从后往前
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m + n -1;

        while ((p1 >= 0) && (p2 >= 0)){
            // 从尾端开始，选择较大的放在nums1尾部
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        while (p2 >= 0){
            nums1[p2] = nums2[p2];
            p2--;
        }

        for (int index = 0; index < nums1.length; index++){
            System.out.println(nums1[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};

        merge2(nums1, 0, nums2, 1);
    }
}
