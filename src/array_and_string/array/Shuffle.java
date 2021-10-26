package array_and_string.array;

import java.util.*;

public class Shuffle {

    // 随机操作数组
    int[] nums;
    // 原数组
    int[] origin;

    public Shuffle(int[] nums) {
        this.origin = nums;
        this.nums = nums.clone();
    }

    // 将随机操作数组变回原数组
    public int[] reset() {
        this.nums = origin.clone();
        return nums;
    }

    // 洗牌算法，数组从右往左遍历，每次在左侧随机选择一个下标，然后交换当前元素和选择的元素
    public int[] shuffle() {
        for (int i = nums.length-1; i >= 0; i--){
            int y = new Random().nextInt(i+1);

            int tmp = nums[i];
            nums[i] = nums[y];
            nums[y] = tmp;
        }
        return nums;
    }
}
