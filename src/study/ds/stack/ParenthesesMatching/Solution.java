package study.ds.stack.ParenthesesMatching;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (isLeft(c)) {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char prev = stack.peek();
                if (match(prev,c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    boolean match(char left, char right) {
        return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
    }
}