package past.jianzhioffer;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;

    }

    /**
     * 0100
     * 0011
     * 0111
     */
    public static void main(String[] args) {
        int[] nums = {3,4,3,3};
        System.out.println(3^4^3^3);
    }
}
