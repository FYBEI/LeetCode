package past.array_and_string.array;

import java.util.Arrays;

public class LeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[0];
        }

        Arrays.sort(arr);

        return Arrays.copyOf(arr, k);
    }
}
