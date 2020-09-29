package HW1;

import java.util.Arrays;

public class HW1_5 {

    /**
     * 数组合并
     */
    private int[] merge(int[] a, int[] b){
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0, x = 0;
        while (i < a.length && j < b.length){
            if (a[i] <= b[j]){
                c[x++] = a[i++];
            }else if (a[i] > b[j]){
                c[x++] = b[j++];
            }
        }

        while (i < a.length){
            c[x++] = a[i++];
        }
        while (j < b.length){
            c[x++] = b[j++];
        }

        return c;
    }

    /**
     * 二分排序
     */
    public int[] sort(int[] nums){
        if (nums.length == 1){
            return nums;
        }

        int middle = nums.length/2;
        int[] a = Arrays.copyOfRange(nums, 0, middle);
        int[] b = Arrays.copyOfRange(nums, middle, nums.length);

        return merge(sort(a), sort(b));
    }

    public static void main(String[] args) {
        //生成随机数组，长度20
        int[] nums = new int[20];
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random()*100);
        }

        System.out.print("测试数组：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }

        HW1_5 hw1_5 = new HW1_5();
        int[] result = hw1_5.sort(nums);

        System.out.print("\n排序结果：");
        for (int i = 0 ; i < result.length; i++){
            System.out.print(result[i]);
            System.out.print(' ');
        }
    }
}
