package past.jianzhioffer;

public class CountDigitOne {
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        long mulk = 1;
        int ans = 0;
        // 这里的k并没有用到，只是表示出来方便理解，表示从个位数开始遍历，枚举每一位数中1的个数
        for (int k = 0; n >= mulk; ++k) {
            // (n / (mulk*10)) * mulk，表示当前位数的循环次数，每次循环最多出现mulk次，例如3120中百位循环了3次，每次循环最多出现100次1
            // 剩余百位为120，需要和100比较，计算出出现1的次数，若小于100，则百位不会出现1，若大于200，则出现100次，如果位于100和200之间，则出现次数为 n % (molk*10) - molk + 1
            ans += (n / (mulk*10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            // mulk*10表示下一位
            mulk *= 10;
        }

        return ans;
    }
}
