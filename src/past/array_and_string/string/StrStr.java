package past.array_and_string.string;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0){
            return 0;
        }

        //将字符串拆分，如果拆分后的数组为空，说明haystack和needle相同或者haystack由多个needle组成
        String[] split = haystack.split(needle);

        if (split.length == 0){
            return 0;
        }

        //选择拆分后的第一个字符串，needle的位置就是第一个字符串下一个
        String tmp = split[0];

        if (tmp.length() == haystack.length()){
            return -1;
        } else {
            return tmp.length();
        }

    }
}
