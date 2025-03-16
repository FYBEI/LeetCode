package begin;

import java.util.*;

public class CountOfSubstrings {

    /**
     * 计算至少包含k个的数量
     * @param word
     * @param m
     * @return
     */
    public long count(String word, int m) {
        // 元音集合
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        // 字符串长度、辅音数量
        int n = word.length(), consonants = 0;
        long res = 0;
        // 元音计数
        Map<Character, Integer> occur = new HashMap<>();
        int j = 0;
        for (int i = 0; i < n; i++) {

            // 窗口右侧右移
            while (j < n && (consonants < m || occur.size() < 5)) {
                char ch = word.charAt(j);
                if (vowels.contains(ch)) {
                    occur.put(ch, occur.getOrDefault(ch, 0) + 1);
                } else {
                    consonants++;
                }
                j++;
            }
            // 由于是计算至少包含k个，所以满足条件后扩展到最右侧的所有子串都符合
            if (consonants >= m && occur.size() == 5) {
                res += n - j + 1;
            }
            // 窗口左侧左移
            char left = word.charAt(i);
            if (vowels.contains(left)) {
                occur.put(left, occur.get(left) - 1);
                if (occur.get(left) == 0) {
                    occur.remove(left);
                }
            } else {
                consonants--;
            }
        }
        return res;
    }

    public long countOfSubstrings(String word, int k) {
        return count(word, k) - count(word, k+1);
    }

    public static void main(String[] args) {
        CountOfSubstrings countOfSubstrings = new CountOfSubstrings();
        String word = "ieaouqqieaouqq";
        int k = 1;
        long result = countOfSubstrings.countOfSubstrings(word, k);
        System.out.println(result);
    }
}
