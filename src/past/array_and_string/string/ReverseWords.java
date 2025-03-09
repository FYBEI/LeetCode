package past.array_and_string.string;

public class ReverseWords {

    /**
     * 申请额外空间
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == ' '){
                sb.append(ch);
                index = i+1;
            }else {
                sb.insert(index, ch);
            }
        }

        return sb.toString();
    }

    /**
     * 原地算法
     */
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for(int i = 0; i < chars.length-1; i++){
            if (chars[i] == ' '){
                int end = i-1;
                change(start, end, chars);
                start = i+1;
            }
        }
        if (start != chars.length){
            change(start, chars.length-1, chars);
        }

        String s1 = String.valueOf(chars);
        return s1;
    }

    private void change(int start, int end, char[] chars){
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String str = "Let's take LeetCode contest";

        rw.reverseWords(str);
    }
}
