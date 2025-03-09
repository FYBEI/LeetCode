package past.array_and_string.array;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return false;
        }

        Integer first = null, second = null;

        for(int n : nums){
            if (first == null){
                first = n;
                continue;
            }
            if (n <= first){
                first = n;
                continue;
            }

            if (second == null){
                second = n;
            }else{
                if (n > second){
                    return true;
                }else{
                    second = n;
                }
            }
        }

        return false;
    }
}
