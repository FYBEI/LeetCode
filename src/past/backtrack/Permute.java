package past.backtrack;

import java.util.*;

public class Permute {

    List<List<Integer>> ans = new ArrayList<>();
    // 标记已排列的数字
    boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {

        vis = new boolean[nums.length];

        List<Integer> list = new ArrayList<>();
        arrange(nums, list);

        return ans;
    }

    // 回溯函数，List为当前已排列的数字
    private void arrange(int[] nums, List<Integer> list){
        // 如果全部数字都已排列，则添加进答案
        if (list.size() == nums.length){
            ans.add(list);
            return;
        }

        // 遍历没有排列过的数字
        for (int i = 0; i < nums.length; i++){
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
        Permute permute = new Permute();

        int[] nums = {4, 2, 5, 6, 1};

        List<List<Integer>> ans = permute.permute(nums);
        System.out.println(ans);
    }
}
