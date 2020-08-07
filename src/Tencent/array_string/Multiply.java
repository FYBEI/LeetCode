package Tencent.array_string;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if (num1.equals("1")){
            return num2;
        }
        if (num2.equals("1")){
            return num1;
        }

        StringBuilder result = new StringBuilder();

        char next = '0';
        for (int i = num1.length(); i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length(); j >= 0; j--){
                int n2 = num2.charAt(j) - '0';

                int tmp = n1*n2 + (next - '0');
                //有进位
                if (tmp / 10 != 0){
                    next = (char) (tmp%10 + '0');
                }   //无进位
                else {
                    next = '0';
                }

            }
        }



        return result.toString();
    }
}
