package dynamic;

public class isInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0){
            return true;
        }

        boolean[][] dp = new boolean[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++){
            if (s3.charAt(0) == s1.charAt(i)){
                dp[i][0] = true;
            }
        }
        for (int j = 0; j < s2.length(); j++){
            if (s3.charAt(0) == s2.charAt(j)){
                dp[0][j] = true;
            }
        }

        for (int i = 1; i < s1.length(); i++){
            for (int j = 1; j < s2.length(); j++){
                char ch = s3.charAt(i+j);
                if (s1.charAt(i) == ch && s2.charAt(j) == ch){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if (s1.charAt(i) == ch){
                    dp[i][j] = dp[i-1][j];
                }else if (s2.charAt(j) == ch){
                    dp[i][j] = dp[i][j-1];
                }else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s1.length()-1][s2.length()-1];
    }
}
