package array_and_string.string;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        int add = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;

            int sum = n1 + n2 + add;

            if (sum >= 10){
                add = 1;
                sum -= 10;
            }else {
                add = 0;
            }

            sb.insert(0, sum);
        }

        if (add != 0){
            sb.insert(0, String.valueOf(add));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "123";

        AddStrings as = new AddStrings();
        String ans = as.addStrings(s1, s2);

        System.out.println(ans);
    }
}
