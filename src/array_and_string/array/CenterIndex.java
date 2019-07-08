package array_and_string.array;

/**
 * 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 */
public class CenterIndex {

    public int pivotIndex(int[] nums) {
        //数组长度小于3都是没有意义的
        if (nums.length < 3){
            return -1;
        }

        //从头开始寻找中间索引,index为数组下标，从第一个元素开始
        int index = 0;

        //初始化索引左右两边的总和
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++){
            right += nums[i];
        }

        do{
            //如果左右之和相等，就返回索引
            if (left == right){
                return index;
            }   //否则将索引向右移动,并重新计算左右之和
            else {
                left += nums[index];
                index++;

                //如果数组遍历完成就跳出循环
                if (index == nums.length){
                    break;
                }
                right -= nums[index];
            }

        }while (true);


        return -1;
    }
}
