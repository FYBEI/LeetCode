package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }

        int j = 0;
        // 记录字符和其对应的位置
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        int tmp = 0;
        while (j < s.length()) {
            char rightChar = s.charAt(j);

            int i = map.getOrDefault(rightChar, 0);
            map.put(rightChar, j);
            maxLen = tmp < j-i ? tmp+1 : j-i;
            maxLen = Math.max(maxLen, tmp);
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lils = new LengthOfLongestSubstring();

        String s = "abcabcbb";
        lils.lengthOfLongestSubstring(s);
    }
}
