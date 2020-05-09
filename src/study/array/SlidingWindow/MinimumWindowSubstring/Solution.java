package study.array.SlidingWindow.MinimumWindowSubstring;


import java.util.HashMap;
import java.util.Map;

class Solution {

    public String minWindow(String s, String t) {
        if (s == null) { return ""; }
        if (t == null || t.length() == 0) { return s; }
        if (s.length() < t.length()) { return ""; }

        HashMap<Character, Integer> mapCharToCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapCharToCount.put(c, mapCharToCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> currentMap = new HashMap<>();


        int left = 0;
        int right = 0;
        String result = null;
        while (right < s.length()) {
            char c = s.charAt(right);
            currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
            right++;

            boolean remainSame = false;
            while ((sourceContainsTarget(currentMap, mapCharToCount) || remainSame) && left < right) {

                String tmp = s.substring(left, right);
                if (result == null || tmp.length() < result.length()) {
                    result = tmp;
                }

                char leftChar = s.charAt(left);
                if (currentMap.containsKey(leftChar)) {
                    remainSame = false;
                } else {
                    remainSame = true;
                }
                currentMap.put(leftChar, currentMap.getOrDefault(leftChar, 1) - 1);
                left++;
            }
        }

        if (result == null) {
            return "";
        } else {
            return result;
        }
    }

    private final boolean sourceContainsTarget(Map<Character, Integer> source, Map<Character, Integer> target) {
        boolean contains = true;
        for (Character character : target.keySet()) {
            if (target.get(character) > source.getOrDefault(character, 0)) {
                contains = false;
                break;
            }
        }
        return contains;
    }

}