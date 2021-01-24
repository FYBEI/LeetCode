package Summary_of_Interview_Problem.string;

/**
 * 验证回文串：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1){
            return true;
        }

        int i = 0;
        int j = s.length()-1;

        s = s.toLowerCase();

        while (i < j){
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))){
                i++;
            }

            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))){
                j--;
            }

            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String s = ",.";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }
}
