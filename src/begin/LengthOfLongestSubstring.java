package begin;

import java.util.Arrays;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }

        // 记录字符出现的最后一个位置，初始为-1
        int[] index = new int[128];
        Arrays.fill(index, -1);

        // 子串的起始位置，或者说是重复字符的位置
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            // 判断当前子串的起始位置
            // 如果字符没重复，则起始位置不变；如果字符重复，起始位置变为重复字符的下一个位置
            start = Math.max(start, index[ch] + 1);
            // 子串长度为当前 右窗口-左窗口+1
            res = Math.max(res, i - start + 1);
            index[ch] = i;
        }

        return res;
    }


}
