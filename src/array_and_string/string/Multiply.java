package array_and_string.string;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("1")){
            return num2;
        }
        if (num2.equals("1")){
            return num1;
        }
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;

        // 乘法结果包进位就为len，最终没进位就为len-1
        int[] ans = new int[len];

        for (int i = 1; i <= len1; i++){
            int n1 = num1.charAt(len1 - i) - '0';

            int add = 0;
            for (int j = 1; j <= len2; j++){

                // 计算的位数
                int index = i + j - 1;
                int n2 = num2.charAt(len2 - j) - '0';

                int res = n1 * n2 + add + ans[len - index];

                if (res >= 10){
                    add = res/10;
                    res = res%10;
                }else {
                    add = 0;
                }

                // 赋予更改位数
                ans[len - index] = res;

                // 如果存在进位，进位加入前一位运算
                while (add > 0){
                    res = ans[len - index - 1] + add;
                    if (res >= 10){
                        add = res/10;
                        res = res%10;
                    }else {
                        add = 0;
                    }
                    ans[len - index - 1] = res;
                    index++;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        if (ans[0] != 0){
            result.append(ans[0]);
        }

        for (int i = 1; i < len; i++){
            result.append(ans[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Multiply mul = new Multiply();

        String num1 = "999";
        String num2 = "999";

        String s = mul.multiply(num1, num2);
        System.out.println(s);
    }
}
