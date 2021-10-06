package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append('(');

        backTrack(n-1, n, sb);
        return ans;
    }

    private void backTrack(int n, int m, StringBuilder sb){
        if (n == 0 && m == 0){
            ans.add(sb.toString());
        }else if (n == 0){
            sb.append(')');
            backTrack(n, m-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }else if (n == m){
            sb.append('(');
            backTrack(n-1, m, sb);
            sb.deleteCharAt(sb.length()-1);
        }else {
            sb.append('(');
            backTrack(n-1, m, sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(')');
            backTrack(n, m-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generateParenthesis(n);
    }
}
