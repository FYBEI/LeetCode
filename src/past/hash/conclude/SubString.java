package past.hash.conclude;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class SubString {

    /**
     * 使用set标记重复
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        int end = 0;

        while (start < s.length()){
            end = start;
            while (end < s.length()){
                if (set.contains(s.charAt(end))){
                    int length = end - start;
                    if (length > max){
                        max = length;
                    }
                    set.clear();
                    break;
                }else if (end == s.length()-1){
                    int length = end - start + 1;
                    if (length > max){
                        max = length;
                    }
                    set.clear();
                    break;
                }
                else{
                    set.add(s.charAt(end));
                    end++;
                }
            }
            start++;
        }

        return max;
    }

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        char[] charArr = s.toCharArray();
        if (charArr.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int baseIndex = 0;
        int i;

        //i从第二个元素开始
        for (i = baseIndex + 1; i < charArr.length; i++) {

            //j从base开始，从前往后找，与第i个相同的元素，并且计算长度
            for (int j = baseIndex; j < i; j++) {

                //如果找到相同元素，base直接跳到当前元素下一个
                if (charArr[j] == charArr[i]) {
                    maxLength = (i - baseIndex) > maxLength ? (i - baseIndex) : maxLength;
                    baseIndex = j + 1;
                    break;
                }
            }
        }

        //全部遍历后还要再计算一次，如果直到最后一位还没有重复元素的情况
        maxLength = (i - baseIndex) > maxLength ? (i - baseIndex) : maxLength;
        return maxLength;
    }
}
