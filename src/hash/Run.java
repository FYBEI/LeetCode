package hash;

import hash.hash_set.Duplicate;
import hash.hash_set.HappyNumber;
import org.junit.Assert;
import org.junit.Test;

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
}
