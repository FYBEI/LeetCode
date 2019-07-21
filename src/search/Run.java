package search;

import org.junit.Assert;
import org.junit.Test;
import search.conclude.GreatestLetter;
import search.conclude.MyPow;
import search.conclude.PerfectSquare;
import search.model1.GuessNum;
import search.model1.MySqrt;
import search.model1.Search;
import search.model2.MinNum;
import search.model2.Peak;
import search.model3.CloseElement;
import search.model3.SearchRange;
import search.practice.Duplicate;
import search.practice.Intersection;
import search.practice.Median;

import java.util.List;

public class Run {
    @Test
    public void mysqrt(){
        MySqrt mySqrt = new MySqrt();

        int result = mySqrt.mySqrt(214);
        int exp = 14;
        Assert.assertEquals(exp, result);

    }

    @Test
    public void guess(){
        GuessNum guessNum = new GuessNum();

        int result = guessNum.guessNumber(10);
        System.out.println(result);
    }

    @Test
    public void search(){
        Search search = new Search();

        int[] nums = {4,5,1,2,3};
        int target = 2;

        int result = search.search(nums, target);
        System.out.println(result);
    }

    @Test
    public void peak(){
        Peak peak = new Peak();

        int[] nums = {2,1,2};

        int result = peak.findPeakElement(nums);
        System.out.println(result);
    }

    @Test
    public void min(){
        MinNum minNum = new MinNum();

        int[] nums = {2,0,1,1,1};

        int result = minNum.findMin2(nums);
        System.out.println(result);
    }

    @Test
    public void range(){
        SearchRange sr = new SearchRange();

        int[] nums = {1};

        int[] result = sr.searchRange(nums, 1);

        System.out.println(result[0] + "," + result[1]);
    }

    @Test
    public void closeElement(){
        CloseElement closeElement = new CloseElement();

        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        List<Integer> result = closeElement.findClosestElements(arr, k, x);

        for (Integer a : result){
            System.out.print(a + " ");
        }
    }

    @Test
    public void pow(){
        MyPow myPow = new MyPow();

        double x = 2;
        int n = -3;

        double result = myPow.myPow(x, n);
        System.out.println(result);
    }

    @Test
    public void square(){
        PerfectSquare perfectSquare = new PerfectSquare();

        int num = 1024;

        Assert.assertTrue(perfectSquare.isPerfectSquare(num));
    }

    @Test
    public void nextletter(){
        GreatestLetter gl = new GreatestLetter();

        char[] letters = {'c', 'f', 'j'};
        char target = 'z';

        char result = gl.nextGreatestLetter(letters, target);
        System.out.println(result);
    }

    @Test
    public void intersection(){
        Intersection intersection = new Intersection();

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
    }

    @Test
    public void duplicate(){
        Duplicate duplicate = new Duplicate();

        int[] nums = {3,1,3,4,2};
        int num = duplicate.findDuplicate2(nums);

        System.out.println(num);
    }

    @Test
    public void median(){
        Median median = new Median();

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double result = median.findMedianSortedArrays(nums1, nums2);

        System.out.println(result);
    }
}
