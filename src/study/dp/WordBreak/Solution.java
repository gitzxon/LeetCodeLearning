package study.dp.WordBreak;

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            hashSet.add(wordDict.get(i));
        }


        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        dp[0] = hashSet.contains(s.charAt(0) + "");


        for (int end = 0; end < s.length(); end++) {

            for (int start = 0; start <= end; start++) {
                String sub = s.substring(start, end + 1);
                if (hashSet.contains(sub)) {
                    if (start == 0 || dp[start - 1]) {
                        dp[end] = true;
                    }
                }
            }

        }
        return dp[s.length() - 1];
    }
}