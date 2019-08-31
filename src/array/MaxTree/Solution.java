package array.MaxTree;

import tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 构造数组的最大树。
 * 生成方法：
 * 1. 每一个数，找到其左边第一个比他大的数，右边第一个比他大的数
 * 2. 两者取最小的那个，为当前节点的父节点。
 */
public class Solution {

    public TreeNode generateMaxTree(int[] array) {

        TreeNode[] treeNodesArray = new TreeNode[array.length];
        Map<TreeNode, TreeNode> leftBigMap = new HashMap<>();
        Map<TreeNode, TreeNode> rightBigMap = new HashMap<>();
        Map<Integer, TreeNode> allNodes = new HashMap<>();

        for (int i = 0; i < treeNodesArray.length; i++) {
            treeNodesArray[i] = new TreeNode(array[i]);
            allNodes.put(i, treeNodesArray[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                popStackAndSetMap(stack, leftBigMap, allNodes);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, leftBigMap, allNodes);
        }


        for (int i = treeNodesArray.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                popStackAndSetMap(stack, rightBigMap, allNodes);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, rightBigMap, allNodes);
        }


        TreeNode root = null;

        for (int i = 0; i < treeNodesArray.length; i++) {
            TreeNode treeNode = treeNodesArray[i];
            TreeNode left = leftBigMap.get(treeNode);
            TreeNode right = rightBigMap.get(treeNode);
            TreeNode smaller = null;
            if (left == null) {
                smaller = right;
            } else if (right == null) {
                smaller = left;
            } else {
                if (left.value <= right.value) {
                    smaller = left;
                } else {
                    smaller = right;
                }
            }

            if (smaller == null) {
                root = treeNode;
            } else {
                if (smaller.left == null) {
                    smaller.left = treeNode;
                } else if (smaller.right == null) {
                    smaller.right = treeNode;
                }
            }
        }

        return root;
    }

    private void popStackAndSetMap(Stack<Integer> stack, Map<TreeNode, TreeNode> map, Map<Integer, TreeNode> allNodes) {
        if (stack.isEmpty()) {
            return;
        }

        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            map.put(allNodes.get(pop), null);
        } else {
            map.put(allNodes.get(pop), allNodes.get(stack.peek()));
        }
    }

    private void printMap(Map<TreeNode, TreeNode> map) {
        System.out.println(Arrays.toString(map.entrySet().toArray()));
    }

    private void printTreeNode(TreeNode[] treeNodes) {
        for (int i = 0; i < treeNodes.length; i++) {
            TreeNode cur = treeNodes[i];
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            System.out.println("i = " + i);
            System.out.println("cur.value = " + cur.value);
            if (left != null) {
                System.out.println("left.value = " + left.value);
            } else {
                System.out.println("left.value = null");
            }

            if (right != null) {
                System.out.println("right.value = " + right.value);
            } else {
                System.out.println("right.value = null");
            }

        }
    }
}
