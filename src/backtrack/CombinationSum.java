package backtrack;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans  = new ArrayList<>();
        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<>();
        backtrack(candidates, 0, target, list);

        return ans;

    }

    private void backtrack(int[] candidates, int i, int target, List<Integer> list){
        if (target == 0){
            ans.add(new ArrayList<>(list));
        }

        for (int j = i; j < candidates.length; j++){

            if (candidates[j] <= target){
                list.add(candidates[j]);
                backtrack(candidates, j, target-candidates[j], list);
                list.remove(list.size()-1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cbs = new CombinationSum();

        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> ans = cbs.combinationSum(candidates, target);
        System.out.println(ans);
    }
}
