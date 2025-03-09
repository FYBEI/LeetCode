package past.array_and_string.conclude;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    //将字符串以" "拆解为多个字符串,取其中的非""字符串
    public String reverseWords(String s) {
        String[] ss = s.split(" ");

        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < ss.length; i++){
            if (!ss[i].equals("")){
                tmp.add(ss[i]);
            }
        }

        if (tmp.size() == 0){
            return "";
        }

        if (tmp.size() == 1){
            return tmp.get(0);
        }

        StringBuilder result = new StringBuilder();
        for (int i = tmp.size()-1; i > 0; i--){
            result.append(tmp.get(i) + " ");
        }
        result.append(tmp.get(0));

        return result.toString();
    }

    //按照C语言的方法对字符串操作，逐个字符读取
    public String reverseWords2(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i == -1) {
                break;
            }

            int j = s.lastIndexOf(' ', i);
            builder.append(s.substring(j + 1, i + 1) + " ");
            i = j - 1;
        }

        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}
