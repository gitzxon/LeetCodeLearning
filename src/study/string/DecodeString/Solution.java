package study.string.DecodeString;

import java.util.Stack;

class Solution {

    public String decodeString(String s) {

        Stack<StringBuilder> contentStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char current = s.charAt(i);

            if (isLetter(current)) {
                if (contentStack.size() == 0) {
                    contentStack.push(new StringBuilder());
                }
                contentStack.peek().append(current);
                i++;
            } else if (Character.isDigit(current)) {
                int value = current - '0';
                int end = i + 1;
                while (end < s.length() && Character.isDigit(s.charAt(end))) {
                    value = value * 10;
                    value += (s.charAt(end) - '0');
                    end++;
                }
                numStack.push(value);
                i = end;
            } else if (current == '[') {
                contentStack.push(new StringBuilder());
                i++;
            } else if (current == ']') {
                StringBuilder stringBuilder = contentStack.pop();
                StringBuilder tmpResult = new StringBuilder();
                int num = numStack.pop();
                for (int j = 0; j < num; j++) {
                    tmpResult.append(stringBuilder);
                }

                if (contentStack.size() != 0) {
                    contentStack.peek().append(tmpResult);
                } else {
                    result.append(tmpResult);
                }
                i++;
            }
        }

        while (contentStack.size() != 0) {
            result.append(contentStack.pop());
        }

        return result.toString();
    }

    private boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

}