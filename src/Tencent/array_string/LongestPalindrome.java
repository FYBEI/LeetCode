package Tencent.array_string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        int head = 0;
        int tail = 1;

        //从头便利
        while (head < s.length()-1){

            //发现与头节点相同的字符
            if (s.charAt(head) == s.charAt(tail)){

                //判断是否比现有的结果长，如果长于result的话就判断是否回文
                if (tail - head > result.length()-1){
                    int left = head;
                    int right = tail;
                    while (left <= right){
                        if (s.charAt(left) != s.charAt(right)){
                            break;
                        }
                        left++;
                        right--;
                    }
                    if (left > right){
                        result.delete(0, result.length());
                        result.append(s, head, tail + 1);
                    }
                }
            }

            tail++;

            //尾指针到底时，头指针向前一步
            if (tail == s.length()){
                head++;
                tail = head + 1;
            }
        }

        return result.toString();
    }

    //最佳答案
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
