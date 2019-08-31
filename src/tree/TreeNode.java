package tree;


public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        value = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}