package past.array_and_string.double_pointer;

public class Exchange {
    public int[] exchange(int[] nums) {
        int n = nums.length;

        if (n == 0){
            return nums;
        }

        int i = 0;
        int j = n-1;

        while(i < j){
            // 位运算可以加快速度
            while (i < j && (nums[i]&1) == 1){
                i++;
            }

            while (i < j && (nums[j]&1) == 0){
                j--;
            }

            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Exchange exc = new Exchange();

        int[] nums = {1, 2, 3, 4};
        int[] res = exc.exchange(nums);

        for (int i : res){
            System.out.println(i);
        }
    }
}
