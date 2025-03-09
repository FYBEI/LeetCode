package past.binary_tree.conclude;

import past.binary_tree.TreeNode;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            String s = "{val:null,left:null,right:null}";
            return s;
        }

        return getChild(root);
    }

    private String getChild(TreeNode root){

        StringBuilder tmp = new StringBuilder("{val:,left:,right:}");
        tmp.insert(5, root.getVal());

        if (root.getLeft() != null){
            int index = tmp.indexOf("left:");
            String left = getChild(root.getLeft());
            tmp.insert(index+"left:".length() , left);
        }else {
            int index = tmp.indexOf("left:");
            tmp.insert(index+"left:".length(), "null");
        }
        if (root.getRight() != null){
            int index = tmp.lastIndexOf("right:");
            String right = getChild(root.getRight());
            tmp.insert(index+"right:".length(), right);
        }else {
            int index = tmp.lastIndexOf("right:");
            tmp.insert(index+"right:".length(), "null");
        }

        return tmp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return setChild(data);
    }

    private TreeNode setChild(String data){

        //读取val:后的值
        int first = data.indexOf(",");
        String val = data.substring(5, first);
        if ("null".equals(val)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        //读取最外层left后的值
        int firstLeft = data.indexOf("left:");

        int i = firstLeft+"left:".length();
        int begin = i;
        int count = 0;
        for (; i < data.length(); i++){
            if (data.charAt(i) == '{'){
                count++;
            }
            if (data.charAt(i) == '}'){
                count--;
            }
            if (count == 0){
                break;
            }
        }
        int end = i;

        String leftdata = data.substring(begin, end);

        //读取最外层right的值
        int firstRight = data.indexOf("right:", end);

        i = firstRight+"right:".length();
        begin = i;
        for (; i < data.length(); i++){
            if (data.charAt(i) == '{'){
                count++;
            }
            if (data.charAt(i) == '}'){
                count--;
            }
            if (count == 0){
                break;
            }
        }
        end = i;

        String rightdata = data.substring(begin, end);

        //如果读到left和right的值，就获取左右结点
        if (leftdata.length() != 0){
            TreeNode left = setChild(leftdata);
            root.setLeft(left);
        }

        if (rightdata.length() != 0){
            TreeNode right = setChild(rightdata);
            root.setRight(right);
        }

        return root;
    }
}
