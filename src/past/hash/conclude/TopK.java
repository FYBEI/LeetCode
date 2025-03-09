package past.hash.conclude;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 输入: count = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: count = [1], k = 1
 * 输出: [1]
 */
public class TopK {

    /**
     * 堆排序
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if (queue.size() == k){
                if (queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else {
                queue.offer(new int[]{num, count});
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = queue.poll()[0];
        }

        return res;
    }

    /**
     * 分治法排序
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            values.add(new int[]{num, count});
        }

        int[] res = new int[k];
        partion(values, 0, values.size()-1, res, 0, k);

        return res;
    }

    private void partion(List<int[]> values, int start, int end, int[] res, int index, int k){
        int pick = new Random().nextInt(end-start+1) + start;
        Collections.swap(values, pick, start);

        int pivot = values.get(start)[1];

        int j = start;
        // 将大于等于标记为的数字移到数组前端
        for (int i = start + 1; i <= end; i++){
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, j+1, i);
                j++;
            }
        }
        Collections.swap(values, j, start);

        // 目前j前段的数字全部比 j 出现次数多，之后的数字全部比 j 出现的次数少
        // 前段数字数量大于k，接着排前k个
        if (k <= j - start){
            partion(values, start, j-1, res, index, k);
        }
        // 前段数字不足k个，说明目前前段数字为前k多的几个，先保存
        else {
            for (int i = start; i <= j; i++){
                res[index++] = values.get(i)[0];
            }

            // 再对后段中的部分进行排序，选取k-(j-start+1)个
            if (k > j-start+1){
                partion(values, j+1, end, res, index, k - (j-start+1));
            }
        }
    }
}
