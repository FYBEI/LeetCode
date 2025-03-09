package past.HW.HW1;

import java.util.Scanner;

public class HW1_3 {

    /**
     * 二分法查找目标数字，找到返回目标数字的位置，未找到返回小于和大于的数字
     * @param nums
     * @param x
     * @return  返回一个数组，长度为1代表找到，长度为2代表没找到，第一个元素为较小的数，第二个元素为较大的数
     */
    public int[] binarySearch(int[] nums, int x){
        //标记小于目标数的位置
        int low = 0;
        //标记大于目标数的位置
        int high = nums.length - 1;

        while (true){
            int middle = (low + high)/2;

            //未发现目标数
            if (middle == low){
                return new int[]{nums[low], nums[high]};
            }

            //当前位置的数字与目标数比较
            if (nums[middle] == x){
                return new int[]{middle};
            }else if (nums[middle] < x){
                low = middle;
            }else if (nums[middle] > x){
                high = middle;
            }
        }
    }

    /**
     * 二分查找测试
     * @param args
     */
    public static void main(String[] args) {
        //输入数组
        Scanner input = new Scanner(System.in);
        System.out.print("输入数组长度：");
        int len = input.nextInt();
        int[] nums = new int[len];
        System.out.print("输入数组：");
        for (int i = 0; i < len; i++){
            nums[i] = input.nextInt();
        }
        //输入目标数
        System.out.print("输入目标数:");
        int x = input.nextInt();

        HW1_3 hw1_3 = new HW1_3();
        int[] result = hw1_3.binarySearch(nums, x);

        if (result.length == 1){
            int index = result[0];
            System.out.println("目标数字所在位置：" + index);
        }else if (result.length == 2){
            int low = result[0];
            int high = result[1];
            System.out.println("小于目标的最大数：" + low);
            System.out.println("大于目标的最小数：" + high);
        }
    }
}
