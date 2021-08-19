package array_and_string.string;

/**
 * KMP算法，用于字符串匹配算法
 */
public class KMP {

    /**
     * 构建next表，表内为p的最长公共前缀后缀的长度，用于指定下次开始匹配的下标
     */
    int[] buildNext(char[] p){
        int m = p.length;

        int[] next = new int[m];

        // 模式串指针
        int t = next[0] = -1;

        int j = 0;
        while (j < m-1){
            // 匹配
            if (t < 0 || p[j] == p[t]){
                j++;
                t++;
                next[j] = t;
                // 此句可改进为 N[j] = (P[j] != P[t] ? t : N[t]);
            }   // 失配
            else {
                t = next[t];
            }
        }

        return next;
    }

    int match(String p, String s){
        // 构造 next 表
        int[] next = buildNext(p.toCharArray());

        // 文本串指针
        int m = p.length();
        int i = 0;
        //模式串指针
        int n = s.length();
        int j = 0;

        // 自左向右逐个比对字符
        while (j < n && i < m){

            // 若匹配，或 P 已移除最左侧
            if (j < 0 || s.charAt(i) == p.charAt(j)){
                // 则转到下一字符
                i++;j++;
            }   // 模式串右移（注意：文本串不用回退）
            else {
                j = next[j];
            }
        }

        return i-j;
    }
}
