package past.hash.hash_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 */
public class Isomorphic {

    /**
     * 使用哈希映射来标记字符
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(t.charAt(i))){
                if (map.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }else {

                //如果映射中不存在该键，但是存在该值，说明键值对匹配出现问题
                if (map.containsValue(s.charAt(i))){
                    return false;
                }
            }

            map.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }

    /**
     * LeetCode上最快的答案，使用Ascii码标注对应的字符
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] ascii = new int[512];
        for (int i = sc.length - 1; i >= 0; i--) {
            if (ascii[sc[i]] != ascii[tc[i] + 256]) {
                return false;
            }
            ascii[sc[i]] = ascii[tc[i] + 256] = i;
        }
        return true;
    }
}
