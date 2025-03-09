package past.hash.conclude;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 */
public class Jewel {
    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0){
            return 0;
        }

        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++){
            jewels.add(J.charAt(i));
        }

        int num = 0;
        for (int i = 0; i < S.length(); i++){
            if (jewels.contains(S.charAt(i))){
                num++;
            }
        }

        return num;
    }

    public int numJewelsInStones2(String J, String S) {
        if (J == null || J.isEmpty()) {
            return 0;
        }
        if (S == null || S.isEmpty()) {
            return 0;
        }

        int num = 0;
        byte[] arry = new byte[58];
        for (char ch : J.toCharArray()) {
            arry[ch - 65] = 1;
        }
        for (char ch : S.toCharArray()) {
            if (arry[ch - 65] == 1) {
                num++;
            }
        }

        return num;
    }
}
