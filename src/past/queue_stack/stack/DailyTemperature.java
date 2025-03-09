package past.queue_stack.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperature {

    /**
     * 正序插入
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1){
            return new int[]{0};
        }

        int[] result = new int[T.length];

        for (int i = 0; i < T.length; i++){
            int value = T[i];

            int j = i + 1;
            for (; j < T.length; j++){
                if (value < T[j]){
                    break;
                }
            }

            int last = 0;
            if (j < T.length){
                last = j - i;
            }

            result[i] = last;
        }

        return result;
    }

    /**
     * 倒叙插入
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int output[] = new int[T.length];

        //最后一个值必为0
        output[T.length - 1] = 0;

        //从倒数第二个开始
        for(int i = T.length - 2; i >= 0; i--){

            int next = i + 1;

            //当前温度大于之后的温度，持续往后找，如果output含有值，说明要再过output[next]项才有可能找到更大的值
            while(T[i] >= T[next]){
                if(output[next] == 0){
                    next = i;
                    break;
                }

                //跳过中间的值
                next += output[next];
            }

            //找到后设置output
            output[i] = next - i;
        }

        return output;

    }

    /**
     * 使用栈来处理
     * @param T
     * @return
     */
    public int[] dailyTemperatures3(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        if (length == 1){
            return res;
        }

        //res[T.length-1] = 0；
        //单调栈,存储T的小标
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;

    }
}
