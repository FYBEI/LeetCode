package Summary_of_Interview_Problem.math;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // 长方形1的最下边大于长方形2的最上边，或者长方形1的最左边大于长方形2的最右边
        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3]){
            return false;
        }
        if (rec2[0] >= rec1[2] || rec2[1] >= rec1[3]){
            return false;
        }

        return true;
    }
}
