package past.search.model3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 */
public class CloseElement {

    /**
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        if (arr.length == k){
            for (int i = 0; i < arr.length; i++){
                result.add(arr[i]);
            }
        }

        int left = 0;
        int right = arr.length-1;

        while (left + 1 < right){
            int mid = left + (right - left)/2;

            if (arr[mid] < x){
                left = mid;
            }else if (arr[mid] > x){
                right = mid;
            }else if (arr[mid] == x){
                left = mid-1;
                right = mid;
                break;
            }
        }

        while (k > 0){
            if (left < 0){
              right++;
              k--;
              continue;
            }
            if (right > arr.length-1){
                left--;
                k--;
                continue;
            }

            if ((x-arr[left]) <= (arr[right]-x)){
                left--;
                k--;
            }else {
                right++;
                k--;
            }
        }

        while (left+1 < right){
            result.add(arr[left+1]);
            left++;
        }

        return result;
    }

    /**
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findCloseElement2(int[] arr, int k, int x){
        List<Integer> res = new ArrayList<>();

        int start = 0;
        int end = arr.length - k;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        for (int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
