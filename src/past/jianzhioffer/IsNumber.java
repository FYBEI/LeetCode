package past.jianzhioffer;

public class IsNumber {
    static public boolean isNumber(String s) {

        // 去除首尾的空格符
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return isNum(s.charAt(0));
        }

        boolean cha = false;
        boolean num = false;
        boolean dot = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // 加减号必须出现在最前面
            if (c == '+' || c == '-') {
                if (num || dot) {
                    return false;
                }

                if (cha) {
                    return false;
                }else {
                    cha = true;
                }
            }else if (c == '.') {
                if (dot) {
                    return false;
                }else {
                    dot = true;
                }
            }
            // e之前必须出现数字，出现e之后判断之后是否为整数
            else if (c == 'e' || c == 'E') {
                if (!num) {
                    return false;
                }
                return isInt(s.substring(i+1, n));
            }else if (isNum(c)) {
                num = true;
            }else {
                return false;
            }
        }

        // 点号必须和数字一起出现，不能单独出现
        if (dot && !num) {
            return false;
        }
        if (!num) {
            return false;
        }

        return true;
    }

    // 判断整数
    static public boolean isInt(String s) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return isNum(s.charAt(0));
        }

        boolean cha = false;
        boolean num = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                if (num) {
                    return false;
                }
                if (cha) {
                    return false;
                }else {
                    cha = true;
                }
            }else if (isNum(c)) {
                num = true;
            }else {
                return false;
            }
        }

        if (!num) {
            return false;
        }

        return true;
    }

    static public boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        String str = "459277e38+";
        boolean res = isNumber(str);
        System.out.println(res);
    }
}
