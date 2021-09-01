package random_problem;

/**
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 *
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 */
public class ValidSerialization {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;


    }

    public static void main(String[] args) {
        ValidSerialization vs = new ValidSerialization();

        String preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        boolean result = vs.isValidSerialization(preorder);

        System.out.println(result);
    }
}
