package array_and_string.string;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];

        // 记录每个字母的数量
        for (int i = 0; i < s.length(); i++){
            num[s.charAt(i) - 'a']++;
        }

        // 模拟栈操作
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // 如果当前字母未访问过（不在栈里）
            if (!vis[ch-'a']){

                // 如果栈顶元素大于当前字母
                while (sb.length() > 0 && sb.charAt(sb.length()-1) > ch){

                    // 如果栈顶元素还有剩余，如果只剩这一个，就要保留
                    if (num[sb.charAt(sb.length()-1) - 'a'] > 0){
                        vis[sb.charAt(sb.length()-1) - 'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }
                }

                // 记录入栈元素
                vis[ch - 'a'] = true;
                sb.append(ch);
            }

            num[ch-'a'] -= 1;
        }

        return sb.toString();
    }
}
