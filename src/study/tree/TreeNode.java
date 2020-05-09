package study.tree;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}