package Summary_of_Interview_Problem.dynamic;

public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n-1, k);
    }

    private int dfs(String s, int l, int r, int k){
        int[] cnt = new int[26];
        // 每个字符计数
        for (int i = l; i <= r; i++){
            cnt[s.charAt(i) - 'a']++;
        }

        // 寻找不满足条件的字符
        char split = 0;
        for (int i = 0; i < 26; i++){
            if (cnt[i] > 0 && cnt[i] < k){
                split = (char) (i+'a');
                break;
            }
        }

        // 未找到不满足条件的字符，说明为最长序列
        if (split == 0){
            return r-l+1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {

            // 过滤掉不满足条件的字符
            while (i <= r && s.charAt(i) == split){
                i++;
            }
            // 过滤后没有其他字符的情况
            if (i > r){
                break;
            }
            // 过滤后的起始位置
            int start = i;
            // 定位结束位置，走到结束位或者再次遇见不满足条件的字符
            while (i <= r && s.charAt(i) != split){
                i++;
            }

            // 缩小范围
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }

        return ret;
    }

}
