package study.tree.SerializeAndDeserialize;

import study.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        Deque<TreeNode> dequeueForTraversal = new LinkedList<>();
        dequeueForTraversal.offerLast(root);

        Deque<TreeNode> dequeForPrint = new LinkedList<>();

        while (dequeueForTraversal.size() != 0) {
            TreeNode treeNode = dequeueForTraversal.pollFirst();
            dequeForPrint.offerLast(treeNode);
            if (treeNode != null) {
                dequeueForTraversal.offerLast(treeNode.left);
                dequeueForTraversal.offerLast(treeNode.right);
            }
        }

        while (dequeForPrint.peekLast() == null) {
            dequeForPrint.pollLast();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (dequeForPrint.size() != 0) {
            TreeNode treeNode = dequeForPrint.pollFirst();
            append(stringBuilder, treeNode);
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] list = data.split("\\[|]|,");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && !list[i].isEmpty()) {
                queue.offer(list[i]);
            }
        }


        TreeNode root = null;
        Queue<TreeNode> queueForTree = null;
        String first = queue.poll();
        if (first == null || first.equals("null")) {
            return null;
        } else {
            root = safeParseTreeNode(first);
            queueForTree = new LinkedList<>();
            queueForTree.offer(root);
        }

        while (queue.size() != 0) {
            TreeNode cur = queueForTree.poll();
            TreeNode left = safeParseTreeNode(queue.poll());
            TreeNode right = safeParseTreeNode(queue.poll());

            if (cur == null) {
                continue;
            }
            cur.left = left;
            cur.right = right;
            if (left != null) {
                queueForTree.offer(left);
            }

            if (right != null) {
                queueForTree.offer(right);
            }
        }

        return root;
    }

    private void append(StringBuilder stringBuilder, TreeNode treeNode) {
        if (treeNode == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(treeNode.val);
        }
        stringBuilder.append(",");
    }

    private TreeNode safeParseTreeNode(String value) {
       return safeParseTreeNode(safeParseInteger(value));
    }

    private TreeNode safeParseTreeNode(Integer integer) {
        if (integer == null) {
            return null;
        } else {
            return new TreeNode(integer);
        }
    }

    private Integer safeParseInteger(String value) {
        if (value == null || value.equals("null")) {
            return null;
        } else {
            return Integer.parseInt(value);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));