package Summary_of_Interview_Problem.sort_search;

import java.util.*;

/**
 * 给定一个整数数组 count，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  count[i] 右侧小于 count[i] 的元素的数量。
 *
 *  
 *
 * 示例：
 *
 * 输入：count = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 */
public class CountSmaller {

    /**
     * 数组c代表桶内所对应数值出现的次数，c为树状数组
     */
    private int[] c;
    /**
     * 数组a代表桶
     */
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);

        // 从原数组末尾往前遍历
        for (int i = nums.length - 1; i >= 0; --i) {
            // 获得当前值所在桶的位置
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            // 更新桶所代表的数值出现的次数
            update(id);
        }

        // 由于原数组按从末尾往前遍历，所以结果应该倒序
        Collections.reverse(resultList);
        return resultList;
    }

    /**
     * 初始化每个桶内数量
     */
    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        // 树状数组必须参数，2^x。x为奇数时，1；x为偶数时，x中2的最大次方因子；x为0时，0。
        return x & (-x);
    }

    /**
     * 更新当前桶所代表的数字出现的次数，pos = count[i]， c[pos]为nums[i]出现的次数
     */
    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;

            pos += lowBit(pos);
        }
    }

    /**
     * 获取标号为pos的桶之前所有桶内数量的总和，即pos = count[i]， 比nums[i]小的数在此之前出现过几次
     */
    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    /**
     * 初始化桶，数组内的值为原数组中的值，且对原数组进行了去重和排序
     */
    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    /**
     * 根据原数组的值获取所在桶的下标
     */
    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

    public static void main(String[] args) {
        CountSmaller cs = new CountSmaller();
        int[] nums = {3, 9, 5, 2, 6, 1, 3};

        List<Integer> result = cs.countSmaller(nums);
        System.out.print(result);
    }
}
