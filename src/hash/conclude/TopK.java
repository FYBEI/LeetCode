package hash.conclude;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class TopK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i])+1);
            }else {
                map.put(nums[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();

        int max = 1;
        int num = nums[0];

        for (int j = 0; j < k; j++){

            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            for (Map.Entry<Integer, Integer> entry:set){
                if (entry.getValue() >= max){
                    max = entry.getValue();
                    num = entry.getKey();
                }
            }

            list.add(num);
            map.remove(num);
            max = 1;
        }

        return list;
    }


    public List<Integer> topKFrequent2(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
