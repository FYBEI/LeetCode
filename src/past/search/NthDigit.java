package past.search;

public class NthDigit {
    public int findNthDigit(int n) {
        if (n < 10){
            return n;
        }

        // table1[i]表示i位数一共有多少数字（按位算）
        // table2[i]表示i位数前一共有多少数字
        int[] table1 = new int[10];
        int[] table2 = new int[10];

        for (int i = 1; i < 9; i++){
            table1[i] = ((int) Math.pow(10, i) - (int) Math.pow(10, i - 1)) * i;
        }
        table2[9] = Integer.MAX_VALUE;

        for (int i = 1; i < 9; i++){
            table2[i] = table2[i-1] + table1[i];
        }

        // n是w+1位数字
        int w = 0;
        for (; w < 9; w++) {
            if (n <= table2[w+1]){
                break;
            }
        }

        // n 的前一位所有数字减掉
        int left = n - table2[w];
        // n是哪个数字上的
        int num = left/(w+1) + (int) Math.pow(10, w);
        // n是num的第几位
        int mod = left % (w+1);

        // 余数为0，表示上一个数字的最后一位
        if (mod == 0){
            num = num-1;
            return num - (num/10)*10;
        }else {
            // 将第mod为缩减到最后一位
            num = num / (int) Math.pow(10, w+1-mod);
            return num - (num/10)*10;
        }
    }
}
