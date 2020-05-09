package study.string.LongestSubstringwithAtLeastKRepeatingCharacters;

import java.util.HashMap;

class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }

        return helper(k, s, 0, s.length() - 1);
    }

    private int helper(int k, String s, int start, int end) {

        if (end - start + 1 < k) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int less = 0;
        int other = 0;
        for (Character character : map.keySet()) {
            if (map.get(character) < k) {
                less += 1;
            } else {
                other += 1;
            }
        }

        if (less == map.size()) {
            return 0;
        } else if (other == map.size()) {
            return end - start + 1;
        }

        for (int i = start; i <= end; i++) {
            if (map.get(s.charAt(i)) < k) {
                int same = i;
                while (same >= 0 && same <= end && s.charAt(same) == s.charAt(i)) {
                    same += 1;
                }
                int left = helper(k, s, start, i - 1);
                int right = helper(k, s, same, end);
                return Math.max(left, right);
            }
        }

        return end - start + 1;
    }
}