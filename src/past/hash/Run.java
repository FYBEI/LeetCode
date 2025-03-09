package past.hash;

import past.binary_search_tree.TreeNode;
import past.hash.conclude.RandomizedSet;
import past.hash.conclude.SubString;
import past.hash.conclude.TopK;
import past.hash.design_key.Anagrams;
import past.hash.design_key.DuplicateSubtree;
import past.hash.hash_map.CommonRestaurant;
import past.hash.hash_map.DuplicateNum;
import past.hash.hash_map.SingleCharacter;
import past.hash.hash_set.Duplicate;
import past.hash.hash_set.HappyNumber;
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
    public void duplicateTree(){
        DuplicateSubtree subtree = new DuplicateSubtree();

        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(4);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.left = a5;
        a3.right = a6;
        a5.left = a7;

        List<TreeNode> result = subtree.findDuplicateSubtrees(a1);

        for (TreeNode treeNode : result){
            System.out.println(treeNode.val);
        }
    }

    @Test
    public void length(){
        SubString subString = new SubString();

        String s = "dvdf";

        int num = subString.lengthOfLongestSubstring(s);
        System.out.println(num);
    }

    @Test
    public void topK(){
        TopK topK = new TopK();

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] list = topK.topKFrequent(nums, k);

        for (Integer num : list){
            System.out.println(num);
        }
    }

    @Test
    public void random(){
        RandomizedSet set = new RandomizedSet();

        boolean a1 = set.insert(1);
        boolean a2 = set.remove(2);
        boolean a3 = set.insert(2);
        int b1 = set.getRandom();
        boolean a4 = set.remove(1);
        boolean a5 = set.insert(2);
        int b2 = set.getRandom();

        System.out.println(a1 + " " + a2 + " " + a3 + " " + b1 + " " + a4 + " " + a5 + " " + b2);
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
