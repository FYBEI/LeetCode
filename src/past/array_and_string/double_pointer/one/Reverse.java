package past.array_and_string.double_pointer.one;

public class Reverse {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;

        while (i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
