package jianzhioffer;

import java.util.*;

public class LengthOfLongestSubstring {
    static public int lengthOfLongestSubstring(String s) {
        int max = 0;
        // 字符即对应位置
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int len = 0;
        while (start+len < s.length()) {
            // 起始字符
            char ch = s.charAt(start + len);
            // 一直找不重复的字符，并计算长度，结束的时候ch为重复字符
            while (!map.containsKey(ch)) {
                map.put(ch, start+len);
                len++;
                // 走到最后一位则提前结束
                if (start + len == s.length()) {
                    break;
                }
                ch = s.charAt(start+len);
            }

            // 更新最大长度
            if (len > max) {
                max = len;
            }
            if (start + len == s.length()) {
                break;
            }

            // 获得重复字符之前出现的位置，从该字符的下一位开始进行第二次遍历
            int next = map.get(ch);
            for (int i = start; i < next; i++) {
                map.remove(s.charAt(i));
            }
            map.put(ch, start+len);
            len = start + len - next;
            start = next+1;
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        lengthOfLongestSubstring(str);
    }
}
