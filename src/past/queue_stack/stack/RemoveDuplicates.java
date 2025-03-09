package past.queue_stack.stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (sb.length() == 0){
                sb.append(ch);
            }else {
                char top = sb.charAt(sb.length()-1);
                if (top == ch){
                    sb.deleteCharAt(sb.length()-1);
                }else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        String s = "abbaca";
        rd.removeDuplicates(s);
    }
}
