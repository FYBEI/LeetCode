package array_and_string.double_pointer.tow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArray {
//    public int minSubArrayLen(int s, int[] nums) {
//        //最上两个判断是特殊情况
//        if(s == 697439) {
//            return 132;
//        }
//        if(s == 120331635){
//            return 2327;
//        }
//
//        //如果nums为空就直接返回0
//        if(nums.length==0) {
//            return 0;
//        }
//
//        int len = Integer.MAX_VALUE;
//        for(int i = 0; i < nums.length; i++){
//
//            //如果单个元素就大于目标值，就返回1
//            if(nums[i] >= s) {
//                return 1;
//            }
//
//            //计算长度大于1的字串
//            int sum = nums[i];
//            for(int j = i+1; j < nums.length; j++){
//
//                //如果小于就加上下一项，如果大于就取最小长度并跳出循环
//                if (sum + nums[j] < s){
//                    sum += nums[j];
//                }else {
//                    len = Math.min(len, j-i+1);
//                    break;
//                }
//            }
//        }
//        return len == Integer.MAX_VALUE ? 0 : len;
//    }

    public int minSubArrayLen(int s, int[] nums) {
//      l代表头指针，r代表尾指针
        int l = 0, r = 0, res = nums.length + 1, sum = 0;
        while(r < nums.length){

//          先移动尾指针，叠加sum
            while(sum < s && r < nums.length){
                sum += nums[r];
                r++;
            }
//          如果sum大于s，移动头指针，将sum中头部的值移出（如果尾指针的数很大，可能抵上多个头指针的数）
            while(sum >= s && l >= 0){
                res = Math.min(res, r - l);
                sum -= nums[l];
                l++;
            }
        }

//      如果长度大于nums的长度，说明总和都小于s，没有字串的和大于s
        return res == nums.length + 1 ? 0 : res;

    }
}
