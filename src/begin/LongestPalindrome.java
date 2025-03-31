package begin;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                // 起始位置 = 中心 - (长度-1)/2
                // 减一是为了应对偶数长度的回文
                start = i - (len - 1) / 2;
                // 截至位置 = 中心 + 长度/2
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        // 对于每个中心往两边扩展，直到边界，或者两端不相等
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        // 返回长度
        return right - left - 1;
    }
}
