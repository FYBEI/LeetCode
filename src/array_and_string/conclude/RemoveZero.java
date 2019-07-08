package array_and_string.conclude;

public class RemoveZero {

    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int slow = 0;

        for(int fast = 0; fast < nums.length; fast++){

            //快指针一直向前走，直到第一个非0元素
            while (fast < nums.length && nums[fast] == 0){
                fast++;
                zeroCount++;
            }

            if(fast >= nums.length){
                break;
            }

            //慢指针从前逐项进行，依次赋予非零元素
            nums[slow] = nums[fast];
            slow++;
        }

        //将之后的元素全部赋予0
        for (int i = nums.length-zeroCount; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
