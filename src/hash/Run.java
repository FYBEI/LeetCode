package hash;

import hash.design_key.Anagrams;
import hash.hash_map.CommonRestaurant;
import hash.hash_map.DuplicateNum;
import hash.hash_map.SingleCharacter;
import hash.hash_set.Duplicate;
import hash.hash_set.HappyNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Run {
    @Test
    public void duplicate(){
        Duplicate duplicate = new Duplicate();

        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        boolean result = duplicate.containsDuplicate(nums);
        Assert.assertTrue(result);
    }

    @Test
    public void happy(){
        HappyNumber happyNumber = new HappyNumber();

        boolean result = happyNumber.isHappy(7);
        Assert.assertTrue(result);
    }

    @Test
    public void restaurant(){
        String[] list1 = {"vacag","KFC"};
        String[] list2 = {"fvo","xrljq","jrl","KFC"};

        CommonRestaurant restaurant = new CommonRestaurant();

        String[] result = restaurant.findRestaurant(list1, list2);
    }

    @Test
    public void singleChar(){
        SingleCharacter singleCharacter = new SingleCharacter();

        String s = "cc";
        int index = singleCharacter.firstUniqChar(s);
        System.out.println(index);
    }

    @Test
    public void dup(){
        DuplicateNum duplicateNum = new DuplicateNum();

        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        boolean result = duplicateNum.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    @Test
    public void anagram(){
        Anagrams anagrams = new Anagrams();

        String[] strs = {"tao","pit","cam","aid","pro","dog"};

        List<List<String>> result = anagrams.groupAnagrams(strs);

        for (int i = 0; i < result.size(); i++){
            for (int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }

    @Test
    public void test(){
        String s = "hello";
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String key = String.valueOf(ca);

        System.out.println(key);
    }
}
