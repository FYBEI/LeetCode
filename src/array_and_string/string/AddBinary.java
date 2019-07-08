package array_and_string.string;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        //选取较短的字符串的长度
        int length = a.length()<b.length() ? a.length() : b.length();

        //进位数
        int carry = 0;

        //从两个字符串的最后一位开始操作，直到较短的字符串操作完成
        for (int i = 0; i < length; i++){
            int aNum = a.charAt(a.length()-1-i) == '0' ? 0 : 1; //a字符串每一位的值
            int bNum = b.charAt(b.length()-1-i) == '0' ? 0 : 1; //b字符串每一位的值

            int total = aNum + bNum + carry;    //每一位总和

            //判断进位操作
            switch (total){
                case 0:{
                    result.insert(0,"0");
                    carry = 0;
                    break;
                }
                case 1:{
                    result.insert(0,"1");
                    carry = 0;
                    break;
                }
                case 2:{
                    result.insert(0,"0");
                    carry = 1;
                    break;
                }
                case 3:{
                    result.insert(0,"1");
                    carry = 1;
                    break;
                }
            }
        }

        //剩余的未操作字符串
        String last = a.length()>b.length() ? a.substring(0, a.length()-length) : b.substring(0, b.length()-length);

        for (int i = last.length()-1; i >= 0; i--){
            int num = last.charAt(i) == '0' ? 0 : 1;
            int total = num + carry;

            switch (total){
                case 0:{
                    result.insert(0,"0");
                    carry = 0;
                    break;
                }
                case 1:{
                    result.insert(0,"1");
                    carry = 0;
                    break;
                }
                case 2:{
                    result.insert(0,"0");
                    carry = 1;
                    break;
                }
            }
        }

        //最后再判断一下是否还有进位，即和的长度大于两个字符串的长度
        if (carry == 1){
            result.insert(0,"1");
        }

        return result.toString();
    }
}
