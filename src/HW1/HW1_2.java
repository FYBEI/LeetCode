package HW1;

public class HW1_2 {

    /**
     * 取中枢纽快速排序法
     * @param nums
     * @param low
     * @param high
     */
    public void quickSortMidPivot(int[] nums, int low, int high){
        if (low >= high){
            return;
        }

        //构建中枢
        findMiddle(nums, low, high);
        int middle = high - 1;
        int left = low;
        int right = high - 1;

        while (true){
            //低位数字小于中枢数字，低位指针就往尾部走
            while (nums[++left] < nums[middle]){}
            //高位数字大于中枢数字，高位指针就往头部走
            while (right > low && nums[--right] > nums[middle]){}

            //低位指针没有超过高位指针，说明此时高位的值小于中枢，低位的值大于中枢，则低高位相互交换
            if (left < right){
                swap(nums, left, right);
            }else {
                break;
            }

        }

        //如果低位指针没有超过上限，说明低位指针超过高位指针，此时低位的值大于中枢，交换低位和中枢
        if (left < high){
            swap(nums, left, middle);
        }

        //此时低位的值为中枢值，以该位置分为两边继续排序
        quickSortMidPivot(nums, low, left-1);
        quickSortMidPivot(nums, left+1, high);
    }

    /**
     * 寻找中间值，并将三个元素进行排序
     */
    private void findMiddle(int[] nums, int low, int high){
        int middle = (low + high)/2;

        //比较低位和中位
        if (nums[low] > nums[middle]){
            swap(nums, low, middle);
        }
        //比较低位和高位
        if (nums[low] > nums[high]){
            swap(nums, low, high);
        }
        //比较高位和中位
        if (nums[high] < nums[middle]){
            swap(nums, high, middle);
        }
        //将中位置于高位前一位
        swap(nums, high-1, middle);
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 取前枢纽快速排序
     * @param nums
     * @param low
     * @param high
     */
    public void quickSortPrePivot(int[] nums, int low, int high){
        if (low >= high){
            return;
        }

        int first = low;
        int last = high;

        int key = nums[first];

        while (first < last){
            //高位指针大于前枢值，高位指针往头部走
            while (first < last && nums[last] > key){
                last--;
            }
            //将比前枢小的值放在低位
            nums[first] = nums[last];

            //低位指针小于前枢值，低位指针往尾部走
            while (first < last && nums[first] < key){
                first++;
            }
            //将比前枢大的值放在高位
            nums[last] = nums[first];
        }
        //将低位替换为前枢
        nums[first] = key;

        //此时低位为中间值，以此位置划分两边继续排序
        quickSortPrePivot(nums, low, first - 1);
        quickSortPrePivot(nums, first + 1, high);
    }

    public static void main(String[] args) {
        //生成随机数组，长度20
        int[] nums = new int[20];
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random()*100);
        }

        //复制随机数组给取前快速排序使用
        int[] nums2 = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }

        System.out.print("测试数组：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }

        //使用取中枢纽进行快速排序
        HW1_2 hw1 = new HW1_2();
        long start = System.currentTimeMillis();
        hw1.quickSortMidPivot(nums, 0, nums.length-1);
        long end = System.currentTimeMillis();
        long cost = end - start;

        System.out.println("\n取中法消耗时间：" + cost + "ms");
        System.out.print("排序结果：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }

        // 使用取前枢纽法快速排序
        long start2 = System.currentTimeMillis();
        hw1.quickSortPrePivot(nums2, 0, nums2.length-1);
        long end2 = System.currentTimeMillis();
        long cost2 = end2 - start2;

        System.out.println("\n取前法消耗时间：" + cost2 + "ms");
        System.out.print("排序结果：");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
            System.out.print(' ');
        }
    }
}
