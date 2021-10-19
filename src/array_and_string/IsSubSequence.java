package array_and_string;

public class IsSubSequence {

    // 动态规划
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl == 0){
            return true;
        }
        if (sl > tl){
            return false;
        }

        boolean dp[][] = new boolean[sl+1][tl+1];
        for (int j = 0; j <= tl; j++){
            dp[0][j] = true;
        }

        for (int i = 1; i <= sl; i++){
            char sc = s.charAt(i-1);
            for (int j = i; j <= tl; j++){
                char tc = t.charAt(j-1);

                if (sc == tc){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[sl][tl];
    }

    // 双指针
    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;
        int sl = s.length();
        int tl = t.length();

        if (sl == 0){
            return true;
        }
        if (sl > tl){
            return false;
        }

        while (i < sl && j < tl){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == sl;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        IsSubSequence isSubSequence = new IsSubSequence();
        System.out.println(isSubSequence.isSubsequence(s, t));
    }
}
