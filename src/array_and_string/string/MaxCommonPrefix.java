package array_and_string.string;

public class MaxCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        StringBuilder prefix = new StringBuilder();

        int minlength = strs[0].length();
        for (String str : strs){
            if (minlength > str.length()){
                minlength = str.length();
            }
        }

        for (int i = 0; i < minlength; i++){
            char a = strs[0].charAt(i);

            for (String str : strs){
                if (a != str.charAt(i)){
                    return prefix.toString();
                }
            }

            prefix.append(a);
        }

        return prefix.toString();
    }
}
