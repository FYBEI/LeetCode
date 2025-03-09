package past.jianzhioffer;

public class FindNthDigit {
    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        // table1[i]表示i位数一共有多少位数字（按位算）
        // table2[i]表示i位数前一共有多少数字
        int[] table1 = new int[10];
        int index = 0;

        for (int i = 0; i < 10; i++) {
            // （当前位所有数字 - 小一位所有数字） * 位数
            table1[i] = ((int) Math.pow(10, i+1) - (int) Math.pow(10, i)) * (i+1);
            if (table1[i] < 0) {
                table1[i] = Integer.MAX_VALUE;
            }

            // 大于当前位数所有数字位数，则减去；等于说明正好为最后一位，直接返回9，小于则停止，表示所求的数字为当前位数
            if (n > table1[i]) {
               n -= table1[i];
            }else if (n == table1[i]){
                return 9;
            }else {
                index = i+1;
                break;
            }
        }

        // b定位第几个数，a表示第几位
        int a = n % index;
        int b = n / index;
        int num = (int) Math.pow(10, index-1) + b;

        // 如果a=0，说明为前一个数字最后一位
        if (a == 0) {
            num = num - 1;
            return num - (num/10)*10;
        }else {
            num = num/ (int) Math.pow(10, index-a);
            return num - (num/10)*10;
        }
    }

    public static void main(String[] args) {
        int a = findNthDigit(30);
        System.out.println(a);
    }
}
