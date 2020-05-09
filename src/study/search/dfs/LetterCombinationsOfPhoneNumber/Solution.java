package study.search.dfs.LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return helper(mapping, new ArrayList<>(), digits, "");
    }

    public List<String> helper(String[] mapping, List<String> resultContainer, String digits, String curString) {
        if (digits.length() == 0) {
            resultContainer.add(curString);
            return resultContainer;
        }

        char c = digits.charAt(0);
        int index = c - '0';
        String chars = mapping[index];
        for (int i = 0; i < chars.length(); i++) {
            helper(mapping, resultContainer, digits.substring(1), curString + chars.charAt(i));
        }

        return resultContainer;
    }
}