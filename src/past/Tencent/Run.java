package past.Tencent;

import past.Tencent.array_string.*;
import org.junit.Test;
import past.prefixSum.ExceptSelf;

import java.util.List;

public class Run {
    @Test
    public void longestPalindrome(){
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        String s = "abacad";
        String result = longestPalindrome.longestPalindrome2(s);
        System.out.println(result);
    }

    @Test
    public void atoi(){
        String str = "0-1";

        MyAtoI myAtoI = new MyAtoI();
        int result = myAtoI.myAtoi(str);

        System.out.println(result);
    }

    @Test
    public void threesum(){
        ThreeSum threeSum = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(nums);

        for (List<Integer> element : result){
            for (Integer num : element){
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Test
    public void threeSumClosest(){
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();

        int[] nums = {0,2,1,-4,4};
        int target = 3;
        int sum = threeSumClosest.threeSumClosest(nums, target);
        System.out.println(sum);
    }

    @Test
    public void maxArea(){
        MaxArea maxArea = new MaxArea();

        int[] height = {76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
        int max = maxArea.maxArea(height);

        System.out.println(max);
    }

    @Test
    public void exceptSelf(){
        ExceptSelf exceptSelf = new ExceptSelf();

        int[] nums = {1,2,3,4};
        int[] result = exceptSelf.productExceptSelf(nums);

        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
