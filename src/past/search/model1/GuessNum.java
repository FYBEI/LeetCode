package past.search.model1;

/**
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 *  输入: n = 10, pick = 6
 * 输出: 6
 */
public class GuessNum {
    private int guess(int num){
        int target = 6;

        if (num < target){
            return 1;
        }else if (num > target){
            return -1;
        }else {
            return 0;
        }
    }

    public int guessNumber(int n) {
        int low = 0;
        int high = n;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (guess(mid) == 0){
                return mid;
            }else if (guess(mid) == -1){
                high = mid-1;
            }else if (guess(mid) == 1){
                low = mid+1;
            }
        }

        return -1;
    }
}
