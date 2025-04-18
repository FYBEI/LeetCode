package past.array_and_string.two_dimensional;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {

        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String s1 = "7.5.2.4";
        String s2 = "7.5.3";

        CompareVersion cv = new CompareVersion();

        int res = cv.compareVersion(s1, s2);

        System.out.println(res);
    }
}
