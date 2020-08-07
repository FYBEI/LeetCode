package dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Run {

    @Test
    public void climb(){
        ClimbFloor climbFloor = new ClimbFloor();
        int result = climbFloor.climb(6);
        System.out.println(result);
    }

    @Test
    public void maxSubArray(){
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray.maxSubArray(nums);
        System.out.println(result);
    }

    @Test
    public void minPathSum(){
        MinPathSum path = new MinPathSum();
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};

        int result = path.minPathSum(grid);
        System.out.println(result);
    }

    @Test
    public void minimumTotal(){
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> tran = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        List<Integer> row5 = new ArrayList<>();
        row5.add(1);
        row5.add(20);
        row5.add(20);
        row5.add(20);
        row5.add(20);
        tran.add(row1);
        tran.add(row2);
        tran.add(row3);
        tran.add(row4);
        tran.add(row5);

        int result = minimumTotal.minimumTotal(tran);
        System.out.println(result);
    }
}
