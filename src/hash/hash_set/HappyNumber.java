package hash.hash_set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1){
            return true;
        }

        if (n == 0){
            return false;
        }

        if (caculate(n, 1) == 1){
            return true;
        }

        return false;
    }

    private int caculate(int num, int index){
        //标记次数，如果遇见无限循环，计数100次就算失败
        if (index == 100){
            return -1;
        }

        //计算每次的结果
        int next = 0;

        while (num  != 0){
            int item = num%10;
            num /= 10;
            next += item*item;
        }

        //如果不是1，继续下一次计算
        if (next != 1){
            return caculate(next, index+1);
        }

        return 1;
    }
}
