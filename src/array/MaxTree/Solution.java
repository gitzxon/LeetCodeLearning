package array.MaxTree;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 生成方法：
 * 1. 每一个数，找到其左边第一个比他大的数，右边第一个比他大的数
 * 2. 两者取最小的那个，为当前节点的父节点。
 */
public class Solution {

    public TreeNode generateMaxTree(int[] array) {

        TreeNode[] treeNodes = new TreeNode[array.length];
        Map<TreeNode, TreeNode> leftBigMap = new HashMap<>();
        Map<TreeNode, TreeNode> rightBigMap = new HashMap<>();

        for (int i = 0; i < treeNodes.length; i++) {
            treeNodes[i] = new TreeNode(array[i]);
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (!stack.isEmpty() && array[stack.peek().value] < array[i]) {

            }
        }
    }
}
