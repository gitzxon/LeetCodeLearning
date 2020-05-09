package study.dp.WordBreakII;

import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new LinkedHashMap<>());
    }

    public List<String> dfs(
            String s,
            List<String> wordDict,
            HashMap<String, LinkedList<String>> tmpResultContainer) {
        if (tmpResultContainer.containsKey(s)) {
            return tmpResultContainer.get(s);
        }

        LinkedList<String> result = new LinkedList<>();
        if (s.equals("")) {
            result.add("");
            return result;
        } else {

            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    List<String> tmpResult = dfs(s.substring(word.length()), wordDict, tmpResultContainer);
                    for (String suffix : tmpResult) {
                        if (suffix.equals("")) {
                            result.add(word);
                        } else {
                            result.add(word + " " + suffix);
                        }
                    }

                }
            }
        }

        tmpResultContainer.put(s, result);
        return result;
    }

    public void test(
            String s,
            List<String> wordDict,
            List<List<String>> resultContainer,
            List<String> current) {
    }
}