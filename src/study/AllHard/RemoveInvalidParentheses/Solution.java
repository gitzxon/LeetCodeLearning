package study.AllHard.RemoveInvalidParentheses;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> answers = new LinkedList<>();

        helper(
                answers,
                s,
                0,
                0,
                '(',
                ')',
                false
        );

        return answers;
    }

    private void helper(
            List<String> answers,
            String s,
            int iStart,
            int jStart,
            char openParentheses,
            char closeParentheses,
            boolean reversed
    ) {

        int count = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParentheses) {
                count++;
            }

            if (s.charAt(i) == closeParentheses) {
                count--;
            }

            if (count >= 0) {
                continue;
            }

            for (int j = jStart; j <= i; j++) {
                if (s.charAt(j) == closeParentheses && (j == jStart || s.charAt(j - 1) != closeParentheses)) {
                    helper(
                            answers,
                            s.substring(0, j) + s.substring(j + 1),
                            i, j, openParentheses, closeParentheses, reversed
                    );
                }
            }

            return;
        }


        if (!reversed) {
            helper(
                    answers,
                    new StringBuilder(s).reverse().toString(),
                    0, 0, closeParentheses, openParentheses, true
            );
        } else {
            answers.add(new StringBuilder(s).reverse().toString());
        }
    }
}