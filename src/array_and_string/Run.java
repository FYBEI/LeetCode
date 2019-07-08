package array_and_string;

import array_and_string.array.AddOne;
import array_and_string.array.CenterIndex;
import array_and_string.array.DoubleMax;
import array_and_string.conclude.*;
import array_and_string.double_pointer.one.ArrayPair;
import array_and_string.double_pointer.one.TwoSum;
import array_and_string.double_pointer.tow.FindMaxConsecutiveOnes;
import array_and_string.double_pointer.tow.MinSubArray;
import array_and_string.double_pointer.tow.RemoveElement;
import array_and_string.string.AddBinary;
import array_and_string.string.MaxCommonPrefix;
import array_and_string.string.StrStr;
import array_and_string.two_dimensional.DiagonalOrder;
import array_and_string.two_dimensional.Spiralmatrix;
import array_and_string.two_dimensional.YHTriangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Run {

    @Test
    public void centetIndex(){
        CenterIndex centerIndex = new CenterIndex();

        int[] nums = {-1,-1,-1,0,1,1};
        int result = centerIndex.pivotIndex(nums);

        Assert.assertEquals(0, result);
    }

    @Test
    public void doubleMax(){
        DoubleMax doubleMax = new DoubleMax();

        int[] nums = {1,0};
        int result = doubleMax.dominantIndex(nums);

        Assert.assertEquals(0, result);
    }

    @Test
    public void addOne(){
        AddOne addOne = new AddOne();

        int[] num1 = {1,2,3};
        int[] result = addOne.plusOne(num1);
        int[] exp1 = {1,2,4};

        int[] num2 = {1,2,9};
        int[] result2 = addOne.plusOne(num2);
        int[] exp2 = {1,3,0};

        int[] num3 = {9,9,9};
        int[] result3 = addOne.plusOne(num3);
        int[] exp3 = {1,0,0,0};

        for (int i = 0; i < result.length; i++){
            Assert.assertEquals(exp1[i], result[i]);
        }

        for (int i = 0; i < result2.length; i++){
            Assert.assertEquals(exp2[i], result2[i]);
        }

        for (int i = 0; i < result3.length; i++){
            Assert.assertEquals(exp3[i], result3[i]);
        }
    }

    @Test
    public void diagonalOrder(){
        DiagonalOrder diagonalOrder = new DiagonalOrder();

        int[][] num = {{3},{2}};

        int[] result = diagonalOrder.findDiagonalOrder(num);
        int[] exp = {3,2};

        for (int i = 0; i < result.length; i++){
            Assert.assertEquals(exp[i], result[i]);
            System.out.print(result[i]);
        }

    }

    @Test
    public void sprialmatrix(){
        Spiralmatrix spiralmatrix = new Spiralmatrix();

        int[][] num = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        List<Integer> result = spiralmatrix.spiralOrder(num);
        int[] exp = {1,2,3,4,8,12,11,10,9,5,6,7};

        for (int i = 0; i < result.size(); i++){
            int a = result.get(i);
            Assert.assertEquals(exp[i], a);
        }
    }

    @Test
    public void yhtri(){
        YHTriangle yhTriangle = new YHTriangle();

        int num = 5;
        List<List<Integer>> result = yhTriangle.generate(5);

        result.stream().forEach(row -> {
            row.stream().forEach(obj -> {
                System.out.print(obj + " ");
            });
            System.out.println();
        });
    }

    @Test
    public void addBinary(){
        AddBinary addBinary = new AddBinary();

        String a = "111";
        String b = "11111";

        String result = addBinary.addBinary(a, b);
        String exp = "100110";
        Assert.assertEquals(exp, result);
    }

    @Test
    public void strStr(){
        StrStr str = new StrStr();

        String a = "a";
        String b = "a";

        int index = str.strStr(a, b);
        int exp = 0;
        Assert.assertEquals(exp, index);
    }

    @Test
    public void longestCommonPrefix() {
        MaxCommonPrefix maxCommonPrefix = new MaxCommonPrefix();

        String[] strs = {"dog","racecar","car"};
        String exp = "";

        String result = maxCommonPrefix.longestCommonPrefix(strs);
        Assert.assertEquals(exp, result);
    }

    @Test
    public void arrayPair(){
        ArrayPair arrayPair = new ArrayPair();

        int[] nums = {1,4,3,2};
        int exp = 4;

        int result = arrayPair.arrayPairSum(nums);

        Assert.assertEquals(exp, result);
    }

    @Test
    public void twoSum(){
        TwoSum twoSum = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] indexs = twoSum.twoSum(nums, target);
        int[] exp = {1,2};

        Assert.assertEquals(exp[0], indexs[0]);
        Assert.assertEquals(exp[1], indexs[1]);
    }

    @Test
    public void removeEle(){
        RemoveElement removeElement = new RemoveElement();

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int len = removeElement.removeElement(nums, val);

        for (int i = 0; i < len; i++){
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void findMaxOne(){
        FindMaxConsecutiveOnes find = new FindMaxConsecutiveOnes();

        int[] nums = {0,1,1,0,1,1,1,0,1,1,1,1};

        int max = find.findMaxConsecutiveOnes(nums);
        int exp = 4;
        Assert.assertEquals(exp, max);
    }

    @Test
    public void minSubArray(){
        MinSubArray minSubArray = new MinSubArray();

        int[] nums = {2,3,1,2,4,3};
        int exp = 2;

        int result = minSubArray.minSubArrayLen(7 , nums);
        Assert.assertEquals(exp, result);
    }

    @Test
    public void rotate(){
        Rotate rotate = new Rotate();

        int[] nums = {1,2};
        int k = 1;
        rotate.rotate(nums, k);

        for (int num : nums){
            System.out.print(num + " ");
        }
    }

    @Test
    public void yhtriangle(){
        array_and_string.conclude.YHTriangle yhTriangle = new array_and_string.conclude.YHTriangle();

        List<Integer> result = new ArrayList<>();

        result = yhTriangle.getRow(6);

        result.stream().forEach(obj -> {
            System.out.print(obj + " ");
        });
    }

    @Test
    public void reverseWords(){
        ReverseWords reverseWords = new ReverseWords();

        String test = "  hello world!  ";
        String result = reverseWords.reverseWords(test);

        System.out.print(result);
    }

    @Test
    public void reverseWord(){
        ReverseWord reverseWord = new ReverseWord();

        String test = "Let's take LeetCode contest";
        String result = reverseWord.reverseWords(test);

        System.out.print(result);
    }

    @Test
    public void removeDuplicate(){
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();

        int[] nums = {0,0,1,1,1,2,2,3,3,4,5,5,5,6,6,9,9,9};
        int n = removeDuplicate.removeDuplicates(nums);

        for (int i = 0; i < n; i++){
            System.out.print(nums[i]);
        }
    }

    @Test
    public void removeZero(){
        RemoveZero removeZero = new RemoveZero();

        int[] nums = {0,1,0,0,0,0,3,12,0,0,4,5,6,0,0};
        removeZero.moveZeroes(nums);

        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

}
