package past.Summary_of_Interview_Problem.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 分割回文串:给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PartionPalindrome {
    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 预处理: 先记住s[i][j]是否为回文字符串, 在之后的回溯当中就不用判断
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;

    }

    /**
     * 回溯
     * @param s
     * @param start 起始位置
     * @param len   字符串长度
     * @param dp    记录s从i到j是否为回文
     * @param path  记录从根到叶子节点的路径
     * @param res   记录所有记录
     */
    private static void backtracking(String s,
                                     int start,
                                     int len,
                                     boolean[][] dp,
                                     Deque<String> path,
                                     List<List<String>> res) {
        // 该分支走完，则将以找到的回文保存
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 从起始位置开始, 一步步寻找回文子串
        for (int i = start; i < len; i++) {
            // 剪枝
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            // 下一支从切分处开始
            backtracking(s, i + 1, len, dp, path, res);
            // 回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "abb";
        List<List<String>> result = partition(s);

        for (List<String> l:result){
            for (String str:l){
                System.out.print(str + '，');
            }
            System.out.println(' ');
        }
    }
}
