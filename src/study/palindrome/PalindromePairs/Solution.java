package study.palindrome.PalindromePairs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static boolean isPalindrome(String text) {
        return isPalindrome(text, 0, text.length() - 1);
    }

    private static boolean isPalindrome(String text, int start, int end) {
        if (start > end) {
            return false;
        }
        int i = start;
        int j = end;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            } else {
                i += 1;
                j -= 1;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> selfPalindromeList = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                emptyList.add(i);
            }

            if (isPalindrome(words[i])) {
                selfPalindromeList.add(i);
            }
        }

        for (int i = 0; i < selfPalindromeList.size(); i++) {
            for (int j = 0; j < emptyList.size(); j++) {
                addResult(result,selfPalindromeList.get(i) , emptyList.get(j));
                addResult(result, emptyList.get(j), selfPalindromeList.get(i));
            }
        }

        TrieNode reverseTrieRoot = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                continue;
            }
            reverseTrieRoot.insert(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                continue;
            }

            String word = words[i];
            TrieNode curNode = reverseTrieRoot;

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!curNode.nextMap.containsKey(c)) {
                    break;
                }
                if (curNode.nextMap.containsKey(c)) {
                    curNode = curNode.nextMap.get(c);
                    if (j == word.length() - 1) {
                        if (curNode.isEnd) {
                            addResult(result, i, curNode.originIndex);
                        }
                        for (Integer integer : curNode.palindromeFromHereList) {
                            addResult(result, i, integer);
                        }
                    } else {
                        if (curNode.isEnd
                                && isPalindrome(word, j + 1, word.length() - 1)) {
                            addResult(result, i, curNode.originIndex);
                        }
                    }
                }
            }

        }

        return result;
    }


    private void addResult(List<List<Integer>> result, int i, int j) {
        if (i == -1 || j == -1) {
            return;
        }
        if (i == j) {
            return;
        }
        List<Integer> pair = new ArrayList<>(2);
        pair.add(i);
        pair.add(j);
        result.add(pair);
    }


    private static class TrieNode {
        HashMap<Character, TrieNode> nextMap = new HashMap<>();
        boolean isEnd;
        int originIndex = -1;
        List<Integer> palindromeFromHereList = new ArrayList<>();

        private void insert(String originString, int index) {
            String text = reverse(originString);
            TrieNode cur = this;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (isPalindrome(text, i, text.length() - 1)) {
                    cur.palindromeFromHereList.add(index);
                }

                if (!cur.nextMap.containsKey(c)) {
                    cur.nextMap.put(c, new TrieNode());
                }
                cur = cur.nextMap.get(c);
            }
            cur.isEnd = true;
            cur.originIndex = index;
        }
    }


}
