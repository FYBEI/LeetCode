package array_and_string;

public class ReMatch {

    /**
     * 动态规划实现方法
     */
    public boolean isMatch_dynamic(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] 表示 s[:i]和p[:j]是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 空字符串可以匹配
        dp[0][0] = true;
        // 超过p开头出现的*号个数就是false
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 遇见*，考虑是否使用*，如果不使用*，则为dp[i][j-1]，否则为dp[i-1][j]
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                // 如果字母相同或者通配符为？，则为dp[i-1][j-1]
                else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 贪心算法实现
     * 需要将p构造成 *u1*u2*u3*的形式，在依次匹配最近的u1、u2、u3
     */
    public boolean isMatch_greedy(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        // 如果p的结尾不为*，则一直匹配s和p的结尾字符，直到p为空或者p的结尾为*为止。
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                --sRight;
                --pRight;
            } else {
                return false;
            }
        }

        if (pRight == 0) {
            return sRight == 0;
        }

        // sRecord和pRecord设置为-1，默认开头不是*号，如果在匹配失败的时候仍为-1，说明开头确实没有*，不可匹配
        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight) {
            // 匹配到*号，更新sRecord和pRecord
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            }
            // 匹配成功
            else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            }
            // 匹配失败，如果sRecord != -1，且s没有遍历完，使用通配符*匹配一个字符，从*位重新匹配
            else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        return allStars(p, pIndex, pRight);
    }

    private boolean allStars(String str, int left, int right) {
        for (int i = left; i < right; ++i) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }


    public static void main(String[] args) {
        String s = "mississippi";
        String p = "m*iss*iss*";

        ReMatch reMatch = new ReMatch();
        boolean re = reMatch.isMatch_dynamic(s, p);
        System.out.println(re);
    }
}
