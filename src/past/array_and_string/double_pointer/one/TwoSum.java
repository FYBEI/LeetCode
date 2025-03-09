package past.array_and_string.double_pointer.one;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;

        int[] indexs = new int[2];

        //和=首尾相加，如果和小于目标，将头指针往后移一位；如果和大于目标，尾指针往前移一位
        while (i < j){
            int total = numbers[i] + numbers[j];
            if (total > target){
                j--;
            }else if (total < target){
                i++;
            }else if (total == target){
                indexs[0] = i+1;
                indexs[1] = j+1;
                return indexs;
            }
        }

        return indexs;
    }
}
