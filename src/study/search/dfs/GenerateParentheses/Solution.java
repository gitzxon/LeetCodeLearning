package study.search.dfs.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        return helper(new ArrayList<>(), n, n, "");
    }

    private List<String> helper(List<String> resultContainer, int remainLeft, int remainRight, String curString) {
        if (remainLeft == 0 && remainRight == 0) {
            resultContainer.add(curString);
            return resultContainer;
        }

        if (remainLeft > 0) {
            helper(resultContainer, remainLeft - 1, remainRight, curString + "(");
        }

        if (remainRight > remainLeft) {
            helper(resultContainer, remainLeft, remainRight - 1, curString + ")");
        }

        return resultContainer;
    }
}