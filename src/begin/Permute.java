package begin;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int[] visited = new int[nums.length];
        fill(nums, visited, new ArrayList<>());

        return res;
    }

    private void fill(int[] nums, int[] visited, List<Integer> tmp) {
        // 遍历完成则添加到结果数组中
        if (tmp.size() == nums.length) {
            res.add(tmp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 已经遍历过则跳过
            if (visited[i] == 1) {
                continue;
            }
            // 为遍历过添加
            // 复制一份新的数组
            List<Integer> copy = new ArrayList<>(tmp);
            copy.add(nums[i]);
            // 标记使用位
            visited[i] = 1;
            // 递归遍历
            fill(nums, visited, copy);

            // 使用往后回退
            visited[i] = 0;
        }
    }
}
