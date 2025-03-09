package past.array_and_string.string;

public class SubStrings {
    public String subStrings(String num1, String num2) {
        String res;

        // 判断num1 和 num2 的大小关系，决定计算顺序，结果是否为负值，是否相等
        int compare = compare(num1, num2);
        if (compare == -1){

            res = sub(num2, num1);
            res = "-" + res;
        }else if (compare == 1){
            res = sub(num1, num2);
        }else {
            res = "0";
        }

        return res;
    }

    /**
     * 比较num1和num2，num1 > num2 则返回 1，num1 < num2 则返回 -1，num1 == num2 则返回 0
     * @param num1
     * @param num2
     * @return
     */
    private int compare(String num1, String num2){
        if (num1.length() < num2.length()){
            return -1;
        }else if (num1.length() > num2.length()){
            return 1;
        }

        for (int i = 0; i < num1.length(); i++){
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);

            if (c1 < c2){
                return -1;
            }else if (c1 > c2){
                return 1;
            }
        }

        return 0;
    }

    /**
     * 计算 num1 - num2的值，num1一定大于num2
     * @param num1
     * @param num2
     * @return
     */
    private String sub(String num1, String num2){
        // 双指针定位两个字符串
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder res = new StringBuilder();

        // 借位初始为0
        int borrow = 0;
        while (i >= 0 || j >= 0){
            // 如果超出范围，则设置为0
            int x = i >= 0 ? (num1.charAt(i--) - '0') : 0;
            int y = j >= 0 ? (num2.charAt(j--) - '0') : 0;

            // 当前位置计算结果
            int n = x - y - borrow;
            // 如果计算结果小于0，则需要借位，结算结果 + 10，借位 = 1
            if (n < 0){
                n += 10;
                borrow = 1;
            }else {
                borrow = 0;
            }

            res.insert(0, n);
        }

        // 去除前置的0
        int pos;
        for (pos = 0; pos < res.length(); pos++){
            if (res.charAt(pos) != '0'){
                break;
            }
        }

        return res.substring(pos, res.length());
    }

    public static void main(String[] args) {
        SubStrings subs = new SubStrings();

        String num1 = "141231";
        String num2 = "552125133";

        String res = subs.subStrings(num1, num2);
        System.out.println(res);
    }
}
