package HW.HW3;

public class TreeNode implements Comparable<TreeNode> {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + val +
                '}';
    }

    @Override
    public int compareTo(TreeNode o) {
        //从小到大排序
        return this.val - o.val;
    }
}
