package Summary_of_Interview_Problem.string;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m){
            return false;
        }

        int[] chs = new int[26];
        for (int i = 0; i < n; i++){
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);

            if (s_ch != t_ch){
                int x = s_ch - 'a';
                int y = t_ch - 'a';
                chs[x]++;
                chs[y]--;
            }

        }

        for (int i = 0; i < chs.length; i++){
            if (chs[i] != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram(s, t));
    }
}
