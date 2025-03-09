package past.prefixSum;

public class ConstructArr {
    public int[] constructArr(int[] a) {
        if (a.length == 0){
            return new int[0];
        }

        // answer[i] 先表示 a[i] 左边元素的乘积
        int[] answer = new int[a.length];
        answer[0] = 1;

        for (int i = 1; i < a.length; i++){
            answer[i] = answer[i-1] * a[i-1];
        }

        // r 为 a[i] 右边元素的乘积
        int r = 1;

        for (int i = a.length-1; i >= 0; i--){
            answer[i] = answer[i] * r;
            r *= a[i];
        }

        return answer;
    }
}
