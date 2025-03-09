package past.random_problem;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }

        // 滑动窗口范围内，在s1中出现的字符就减一，在s2中出现的字符就加一，如果计数为0，说明在s1和s2中出现次数相等
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }

        // 记录出现数量不等的字母的个数
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {

            // x记录移除窗口的字符，y记录移入窗口的字符
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            // 字符一样，就跳过
            if (x == y) {
                continue;
            }

            // 原本一样个数的字母，现在不一样了，变更diff和记录
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }

            // 不断变更，直到出现数量一样
            if (diff == 0) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        CheckInclusion check = new CheckInclusion();

        String s1 = "adc";
        String s2 = "dcda";

        boolean result = check.checkInclusion(s1, s2);
        System.out.println(result);
    }
}
