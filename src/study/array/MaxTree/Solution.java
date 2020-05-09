package study.array.MaxTree;

import study.tree.TreeNode;

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
        handleGenerateBigMap(true, array, treeNodesArray, leftBigMap, allNodes, stack);
        handleGenerateBigMap(false, array, treeNodesArray, rightBigMap, allNodes, stack);

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
                if (left.val <= right.val) {
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

    private void handleGenerateBigMap(boolean fori, int[] array, TreeNode[] treeNodesArray, Map<TreeNode, TreeNode> bigMap, Map<Integer, TreeNode> allNodes, Stack<Integer> stack) {
        int start;
        int end;
        int step;
        if (fori) {
            start = 0;
            end = treeNodesArray.length;
            step = 1;
        } else {
            start = treeNodesArray.length - 1;
            end = -1;
            step = -1;
        }

        for (int i = start; i != end; i = i + step) {
            handlePushStack(array, bigMap, allNodes, stack, i);
        }

        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, bigMap, allNodes);
        }
    }

    private void handlePushStack(int[] array, Map<TreeNode, TreeNode> leftBigMap, Map<Integer, TreeNode> allNodes, Stack<Integer> stack, int i) {
        while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
            popStackAndSetMap(stack, leftBigMap, allNodes);
        }

        stack.push(i);
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

}
