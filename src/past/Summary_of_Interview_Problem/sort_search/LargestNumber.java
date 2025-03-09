package past.Summary_of_Interview_Problem.sort_search;

/**
 * 给定一组非负整数 count，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 示例 1：
 *
 * 输入：count = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：count = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：count = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：count = [10]
 * 输出："10"
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {

        if (nums.length == 1){
            return String.valueOf(nums[0]);
        }

        StringBuilder res = new StringBuilder();

        quickSort(nums, 0, nums.length-1);

        if (nums[nums.length-1] == 0){
            return "0";
        }

        for (int i = nums.length-1; i >= 0; i--){
            res.append(nums[i]);
        }

        return res.toString();
    }


    // 快排
    private void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }

        int i = left, j = right;

        //快速排序
        int tmp = nums[left];
        while (i != j){
            while (compare(nums[j], tmp) && i < j){
                j--;
            }

            while (compare(tmp, nums[i]) && i < j){
                i++;
            }

            if (i < j){
                int a = nums[i];
                nums[i] = nums[j];
                nums[j] = a;
            }

        }

        nums[left] = nums[i];
        nums[i] = tmp;

        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }


    //两数比较法则
    private boolean compare(int a, int b){
        String stra = new StringBuilder().append(a).append(b).toString();
        String strb = new StringBuilder().append(b).append(a).toString();

        int i = 0, j = 0;

        while (i < stra.length() && j < strb.length()){
            char cha = stra.charAt(i);
            char chb = strb.charAt(j);

            // 字符大小相同就比较下一步
            if (cha == chb){
                i++;
                j++;
            }else if (cha > chb){
                return true;
            }else if (cha < chb){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();

        int[] nums = {34323, 3432};
        String res = ln.largestNumber(nums);
        System.out.printf(res);
    }
}
