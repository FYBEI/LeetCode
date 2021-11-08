package search.model3;

public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        // 两种特殊情况：
        // 1. 数组最小数字大于k，说明缺失的前k个数在数组前
        // 2. 数组从1开始没有缺失数字，说明缺失的第k个数在数组后第k个
        if (arr[left] > k){
            return k;
        }
        if (arr[right] == right + 1){
            return arr[right] + k;
        }

        while (left + 1 < right){
            int mid = (left + right) >> 1;
            // t表示arr[mid] 前缺失的数字个数
            int t = arr[mid] - mid - 1;

            if (k > t){
                left = mid;
            }else {
                right = mid;
            }
        }

        int ans;
        int t = arr[right] - right - 1;

        // 判断缺失的k个数字是否在数组内
        if (t >= k){
            ans = arr[left] + k - (arr[left] - left - 1);
        }else{
            ans = arr[right] + k - t;
        }

        return ans;
    }
}
