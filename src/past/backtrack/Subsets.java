package past.backtrack;

import java.util.*;

public class Subsets {

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        // 先添加一个空数组
        ans.add(new ArrayList<>());

        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list);

        return ans;
    }

    /**
     * 回溯法获得子集，每次从nums的第i个位置开始遍历，从而避免之前添加过的数字重复添加
     */
    private void backtrack(int[] nums, int i, List<Integer> list) {
        for (int j = i; j < nums.length; j++){
            list.add(nums[j]);

            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            ans.add(tmp);

            // 从当前位置的下一个位置继续添加元素
            backtrack(nums, j+1, list);

            // 回溯
            list.remove(list.size()-1);
        }
    }
}
