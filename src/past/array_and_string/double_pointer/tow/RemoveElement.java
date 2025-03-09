package past.array_and_string.double_pointer.tow;

/**
 *给定一个数组 count 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 给定 count = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 count 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int slow = 0, fast = 0;

        for (; fast < n; fast++){
            while(fast < n && nums[fast] == val){
                fast++;
            }
            if (fast >= n){
                break;
            }

            nums[slow++] = nums[fast];
        }

        return slow;
    }
}
