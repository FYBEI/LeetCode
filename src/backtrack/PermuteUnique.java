package backtrack;

import java.util.*;

public class PermuteUnique {

    List<List<Integer>> ans = new ArrayList<>();
    // 标记已排列的数字
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {

        vis = new boolean[nums.length];

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        arrange(nums, list);

        return ans;
    }

    private void arrange(int[] nums, List<Integer> list) {
        // 如果全部数字都已排列，则添加进答案
        if (list.size() == nums.length){
            ans.add(list);
            return;
        }

        // 遍历没有排列过的数字
        for (int i = 0; i < nums.length; i++){

            // 如果当前数字非第一个数，且这个数之前出现过，但是没有排列过，说明这个数字重复，且其已经完成过排列
            if (i > 0 && nums[i] == nums[i-1] && !vis[i-1]){
                continue;
            }

            if (!vis[i]){

                // 每次排列需要复制一份新的数组传递到下一层
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);

                // 标记最新排列的数字
                tmp.add(nums[i]);
                vis[i] = true;
                arrange(nums, tmp);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();

        int[] nums = {3, 3, 0, 3};
        List<List<Integer>> ans = permuteUnique.permuteUnique(nums);
        System.out.println(ans);
    }
}
