package palindrome.PalindromePairs;


import org.jetbrains.annotations.NotNull;

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

        TrieNode reverseTrieRoot = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            reverseTrieRoot.insert(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();

        // handle empty and self-palindrome
//        List<Integer> emptyList = new ArrayList<>();
//        List<Integer> palindromeList = new ArrayList<>();
//        for (int i = 0; i < words.length; i++) {
//            if (words[i] == null || words[i].length() == 0) {
//                emptyList.add(i);
//            } else if (isPalindrome(words[i])) {
//                palindromeList.add(i);
//            }
//        }
//        for (int i = 0; i < emptyList.size(); i++) {
//            for (int j = 0; j < palindromeList.size(); j++) {
//                addResult(result, emptyList.get(i), palindromeList.get(j));
//                addResult(result, palindromeList.get(j), emptyList.get(i) );
//            }
//        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = reverseTrieRoot;
            boolean wordNotEnough = false;
            if (word.length() == 0) {
                wordNotEnough = true;
            } else {

                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);

                    // 这里 handle 了所有 trie 耗尽的情况
                    if (cur.isEnd) {
                        if (isPalindrome(word, j, word.length() - 1)) {
                            addResult(result, i, cur.originIndex);
                        }
                    }

                    if (cur.nextMap.containsKey(c)) {
                        cur = cur.nextMap.get(c);
                    }
                }

                if (!cur.isEnd) {
                    wordNotEnough = true;
                }
            }

            if (wordNotEnough) {
                if (cur.nextMap.keySet().size() != 0) {
                    List<TrieNode.RemainingResultWrapper> remainingResultWrapperList = cur.findRemaining();
                    for (TrieNode.RemainingResultWrapper remainingResultWrapper : remainingResultWrapperList) {
                        boolean isPalindrome = isPalindrome(words[remainingResultWrapper.originIndex], 0, remainingResultWrapper.size - 1);
                        if (isPalindrome) {
                            addResult(result, i, remainingResultWrapper.originIndex);
                        }
                    }
                }
            }

        }

        return result;
    }


    private void addResult(List<List<Integer>> result, int i, int j) {
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
        int originIndex;

        private void insert(String originString, int index) {
            String text = reverse(originString);
            TrieNode cur = this;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                TrieNode nextNode = cur.nextMap.getOrDefault(c, new TrieNode());
                cur.nextMap.put(c, nextNode);
                cur = nextNode;
            }
            cur.isEnd = true;
            cur.originIndex = index;
        }

        private TrieNode startWith(String text) {
            if (text == null || text.length() == 0) {
                return this;
            }
            TrieNode cur = this;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (cur.nextMap.containsKey(c)) {
                    cur = cur.nextMap.get(c);
                } else {
                    return null;
                }
            }
            return cur;
        }

        private List<RemainingResultWrapper> findRemaining() {
            TrieNode cur = this;
            return performFindRemaining(new ArrayList<>(), 0, cur);
        }

        private List<RemainingResultWrapper> performFindRemaining(List<RemainingResultWrapper> resultContainer, int curSize, TrieNode curNode) {
            if (curNode.nextMap.keySet().size() == 0) {
                resultContainer.add(new RemainingResultWrapper(
                        curSize,
                        curNode.originIndex
                ));
                return resultContainer;
            }

            for (Character character : curNode.nextMap.keySet()) {
                performFindRemaining(resultContainer, curSize + 1, curNode.nextMap.get(character));
            }

            return resultContainer;
        }

        private static class RemainingResultWrapper {
            int size;

            public RemainingResultWrapper(int size, int originIndex) {
                this.size = size;
                this.originIndex = originIndex;
            }

            int originIndex;
        }
    }


}
