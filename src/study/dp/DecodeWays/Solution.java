package study.dp.DecodeWays;

import java.util.HashMap;

class Solution {


    public int numDecodings(String s) {
        return dfs(s, new HashMap<>());
    }

    public int dfs(String s, HashMap<String, Integer> tmpResultContainer) {

        if (s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {

            return 1;
        }

        if (s.length() == 0) {
            return 1;
        }

        if (tmpResultContainer.containsKey(s)) {
            return tmpResultContainer.get(s);
        }

        int first = dfs(s.substring(1), tmpResultContainer);
        int second = 0;

        String firstTwoBit = s.substring(0, 2);
        int firstTwo = Integer.parseInt(firstTwoBit);
        if (firstTwo >= 1 && firstTwo <= 26) {
            second = dfs(s.substring(2), tmpResultContainer);
        } else {
            second = 0;
        }

        int result = first + second;
        tmpResultContainer.put(s, result);
        return result;

    }
}