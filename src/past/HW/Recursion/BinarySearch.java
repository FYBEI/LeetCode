package past.HW.Recursion;

/**
 * 二分搜索：
 * 输入：从小到大顺序排列的数组，目标数
 */
public class BinarySearch {

    static int binarySearch(float[] arr, float target){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left + right)/2;

            if (arr[mid] == target){
                //找到目标数
                return mid;
            }else if (arr[mid] < target){
                //目标数大于中值，说明目标数在右侧
                left = mid + 1;
            }else if (arr[mid] > target){
                //目标数小于中值，说明目标数在左侧
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        float[] arr = {0, 1, 2, 3, 4, 7, 9, 12, 32, 45, 90};
        float targrt = 9;

        int idx = binarySearch(arr, targrt);
        System.out.println(idx);
    }
}
