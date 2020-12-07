package HW.Recursion;


public class Select {

    // 选择排序
    static void slsort(int[] num, int p, int q)
    {
        for (int i = p + 1; i <= q; i++)
        {
            int temp = num[i], j = i - 1;
            while (j >= p)
            {
                if (num[j] > temp)
                {
                    num[j + 1] = num[j];
                    j--;
                }
                else
                    break;
            }
            num[j + 1] = temp;
        }
    }

    /**
     * 分解函数
     * @param arr
     * @param start
     * @param end
     * @param mid
     * @return
     */
    static int partition(int arr[], int start,int end,int mid){
        int i = start, j = end;

        // 将小于中位数的数字移到左边，大于中位数的数字移到右边
        while (i <= end && j >= start) {
            while (arr[i] < mid){i++;}
            while (arr[j] > mid){j--;}
            if (i >= j)
                break;
            else {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        //返回值为中位数所在位置
        return j;
    }

    static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    static int select(int[] arr, int start, int end, int k){
        //当n<30时，算法所用的计算时间不超过一个常数C1
        if (end - start < 30){
            slsort(arr, start, end);
            return arr[start+k-1];
        }

        //将数组以5为单位，分成若干组，交换每组第一位和中位数
        for (int i = 0; i <= (end-start-4)/5; i++){
            int left = start + 5*i;
            int right = left + 4;
            slsort(arr, left, right);

            swap(arr, left, left+2);
        }

        // 选出各种中位数的中位数 mid
        int mid = select(arr, start, start+(end-start-4)/5, (end-start-4)/10);
        // 以mid为基准进行分解
        int i = partition(arr, start, end, mid);    // 划分元位置
        int n = i - start + 1; // 划分元左边的数组长度

        if (k == n) {
            return arr[n];
        }else if (k < n){
            return select(arr, start, i, k);    // 在左边寻找第k大元素
        }else {
            return select(arr, i+1, end, k-n);  // 在右边寻找第k-j大元素
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 15, 67, 44, 86, 53, 21, 57, 75, 64, 24, 31, 77, 94, 32, 66, 89, 90, 35, 47};
        int k = 3;

        int result = select(arr, 0, arr.length-1, k);
        System.out.println(result);
    }
}
