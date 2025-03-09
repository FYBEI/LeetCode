package past.array_and_string.conclude;

public class ReverseWord {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()){
            int j = s.indexOf(' ', i);
            if (j == -1){
                j = s.length();
            }

            String a = s.substring(i, j);
            StringBuilder tmp = new StringBuilder();
            tmp.append(a);

            sb.append(tmp.reverse());

            i = j;
            if (i == s.length()){
                break;
            }else {
                sb.append(s.charAt(i));
                i++;
            }

        }

        return sb.toString();
    }
}
