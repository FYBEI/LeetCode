package past.search.practice;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
public class Intersection {

    /**
     * 输出结果中的每个元素一定是唯一的。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] A = new boolean[1000];
        for (int i = 0; i < nums1.length; i++) {
            A[nums1[i]] = true;
        }
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (A[nums2[i]]) {
                nums1[k] = nums2[i];
                k++;
                A[nums2[i]] = false;
            }
        }
        int[] B = new int[k];
        for (int i = 0; i < k; i++) {
            B[i] = nums1[i];
        }
        return B;
    }

    /**
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++){
            if (!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }else {
                map.replace(nums1[i], map.get(nums1[i])+1);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) >= 1){
                list.add(nums2[i]);
                map.replace(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }

    //leetcode上最快的答案
    public int[] inter(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] inter = new int[len1+len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                if (k > 0 || inter[k-1] != nums1[i]){
                    inter[k++] = nums2[j];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(inter, 0, k);
    }
}
