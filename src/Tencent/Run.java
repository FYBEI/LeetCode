package Tencent;

import Tencent.array_string.LongestPalindrome;
import Tencent.array_string.MyAtoI;
import Tencent.array_string.ThreeSum;
import org.junit.Test;

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
}
