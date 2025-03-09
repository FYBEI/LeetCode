package past.hash.hash_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 */
public class SingleCharacter {

    /**
     * 使用哈希映射，巨慢无比
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                int num = map.get(s.charAt(i));
                map.replace(s.charAt(i), num, num+1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    /**
     * 使用双索引
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int startIndex = s.indexOf(ch);
            if (startIndex != -1 && startIndex == s.lastIndexOf(ch)) {
                index = (index == -1 || index > startIndex) ? startIndex : index;
            }
        }
        return index;
    }
}
