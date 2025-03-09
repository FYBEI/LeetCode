package past.array_and_string.double_pointer;

public class Compress {
    public int compress(char[] chars) {
        int n = chars.length;

        if (n == 1){
            return n;
        }

        // 起始指针，结束指针
        int i = 0;
        int j = i+1;
        // 在原数组上进行操作
        int k = 0;

        while(i < n && j < n){
            if (chars[i] == chars[j]){
                j++;
            }else {
                int num = j - i;
                chars[k++] = chars[i];

                if (num > 1 && num < 10){
                    chars[k++] = (char) ('0' + num);
                }else if(num >= 10){
                    String tmp = String.valueOf(num);
                    for (int x = 0; x < tmp.length(); x++){
                        chars[k++] = tmp.charAt(x);
                    }
                }

                i = j;
                j = i+1;
            }
        }


        int num = j - i;
        chars[k++] = chars[i];

        if (num > 1 && num < 10){
            chars[k++] = (char) ('0' + num);
        }else if(num >= 10){
            String tmp = String.valueOf(num);
            for (int x = 0; x < tmp.length(); x++){
                chars[k++] = tmp.charAt(x);
            }
        }

        return k;
    }

    public static void main(String[] args) {
        char[] chars = {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};

        Compress cp = new Compress();
        cp.compress(chars);
    }
}
