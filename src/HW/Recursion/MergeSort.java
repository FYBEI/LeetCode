package HW.Recursion;

/**
 * 合并排序
 * 输入数组，起始位置，末位
 */
public class MergeSort {

    /**
     * 将a中两段已经排序好的部分合并至b中
     * @param a
     * @param b
     * @param left
     * @param i
     * @param right
     */
    static void merge(float[] a, float[] b, int left, int i, int right){

        //当只有两项时，直接排序
        if (left+1 == right){
            b[0] = a[left] < a[right] ? a[left] : a[right];
            b[1] = a[left] < a[right] ? a[right] : a[left];
            return;
        }

        int x = left;
        int y = i+1;
        int idx = 0;

        while (x <= i && y <= right){
            if (a[x] <= a[y]){
                b[idx++] = a[x++];
            }else {
                b[idx++] = a[y++];
            }
        }

        while (x <= i){
            b[idx++] = a[x++];
        }

        while (y <= right){
            b[idx++] = a[y++];
        }
    }

    /**
     * 将合并好的b重新赋值给a
     * @param a
     * @param b
     * @param left
     * @param right
     */
    static void copy(float[] a, float[] b, int left, int right){
        int j = 0;
        for (int i = left; i <= right; i++){
            a[i] = b[j++];
        }
    }

    static void mergeSort(float[] arr, int left, int right){
        if (left < right){
            int i = (left + right)/2;   //取中点
            mergeSort(arr, left, i);    //合并排序前一半
            mergeSort(arr, i+1, right); //合并排序后一半

            float[] b = new float[right - left + 1];
            merge(arr, b, left, i, right);  //合并到数组b
            copy(arr, b, left, right);  //复制回数组a
        }
    }

    public static void main(String[] args) {
        float[] arr = {49, 38, 65, 97, 76, 13, 27};
        mergeSort(arr, 0, arr.length-1);

        for (float a:arr){
            System.out.println(a);
        }
    }
}
