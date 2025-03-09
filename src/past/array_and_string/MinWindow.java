package past.array_and_string;

public class MinWindow {

    public String minWindow(String s, String t) {
        int n = t.length();
        int m = s.length();

        if (m < n){
            return "";
        }

        // 先记录t中的字符，用数组代替HashMap
        int[] map = new int[100];
        for (int i = 0; i < n; i++){
            char c = t.charAt(i);
            map[c-'A']++;
        }

        // 初始化窗口边界
        int i = 0;
        int j = n-1;
        // 当前窗口包含t中的字母，则对应数量-1
        for (int k = i; k <= j; k++){
            char c = s.charAt(k);
            map[c-'A']--;
        }

        int start = 0;
        int end = 0;
        int len = m+1;

        // 如果未包含所有字符，则移动j，否则移动i
        while(j < m){
            if (j-i+1 < n){
                break;
            }

            // 如果对应map中的字符数量还有大于0的，说明仍有字符没有覆盖
            boolean flag = true;
            for (int val:map){
                if (val > 0){
                    flag = false;
                    break;
                }
            }

            if (flag){
                // 更新最短字符串
                if (j-i+1 < len){
                    start = i;
                    end = j;
                    len = j-i+1;
                }
                // 移动左指针，将对应字符计数+1
                char c = s.charAt(i);
                map[c-'A']++;
                i++;
            }else {
                j++;
                if (j >= m){
                    break;
                }
                char c = s.charAt(j);
                map[c-'A']--;
            }
        }

        return len == m+1 ? "" : s.substring(start, end+1);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();

        String s = "a";
        String t = "a";

        minWindow.minWindow(s, t);
    }

}
