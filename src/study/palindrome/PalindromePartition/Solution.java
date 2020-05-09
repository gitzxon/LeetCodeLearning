package study.palindrome.PalindromePartition;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        return helper(new ArrayList<>(), new ArrayList<>(), s, 0, s.length() - 1);
    }

    private List<List<String>> helper(
            List<List<String>> resultContainer,
            List<String> currentList,
            String s,
            int start,
            int end
    ) {
        if (start >= s.length()) {
            List<String> tmpResult = new ArrayList<>(currentList.size());
            tmpResult.addAll(currentList);
            resultContainer.add(tmpResult);
            return resultContainer;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currentList.add(s.substring(start, i + 1));
                helper(resultContainer, currentList, s, i + 1, end);
                currentList.remove(currentList.size() - 1);
            }
        }

        return resultContainer;

    }

    private boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}