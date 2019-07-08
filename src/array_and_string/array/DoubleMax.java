package array_and_string.array;

/**
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 */
public class DoubleMax {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int max = nums[0];
        int index = 0;


        //查找最大值
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        //判段最大值是否大于其他数的两倍
        for (int i = 0; i < nums.length; i++){
            if (index != i){
                if (max < 2*nums[i]){
                    return -1;
                }
            }

        }

        return index;
    }
}
