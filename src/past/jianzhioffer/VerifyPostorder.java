package past.jianzhioffer;

public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len == 0 || len == 1) {
            return true;
        }

        int root = postorder[len-1];
        int i = len-2;
        for (;i >= 0; i--) {
            if (postorder[i] < root) {
                break;
            }
        }

        boolean left = verify(postorder, 0, i, Integer.MIN_VALUE, root);
        boolean right = verify(postorder, i+1, len-2, root, Integer.MAX_VALUE);
        return left&&right;
    }

    public boolean verify(int[] postorder, int start, int end, int min, int max) {
        // 没有节点
        if (start > end) {
            return true;
        }

        // 最后一位数字即根节点
        int root = postorder[end];

        // 节点的值必须在最大值和最小值范围内
        if (root < min || root > max) {
            return false;
        }
        int i = end-1;
        for (;i >= start; i--) {
            if (postorder[i] < root) {
                break;
            }
        }

        boolean left = verify(postorder, start, i, min, root);
        boolean right = verify(postorder, i+1, end-1, root, max);

        return left&&right;
    }
}
