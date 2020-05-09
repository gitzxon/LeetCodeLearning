package study.SlidingWindow.FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private HashMap<Character, Integer> targetMap = new HashMap<>();
    private int targetCount = 0;
    private HashMap<Character, Integer> curMap = new HashMap<>();
    private int curCount = 0;

    public List<Integer> findAnagrams(String s, String p) {

        if (p == null || p.length() == 0 || s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < p.length(); i++) {
            targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        targetCount = p.length();

        List<Integer> resultContainer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            curMap.put(s.charAt(i), curMap.getOrDefault(s.charAt(i), 0) + 1);
            curCount++;
            if (curCount == targetCount) {
                int start = i - targetCount + 1;
                if (same()) {
                    resultContainer.add(start);
                }
                curCount--;
                curMap.put(
                        s.charAt(start),
                        curMap.getOrDefault(s.charAt(start), 1) - 1);
            }
        }
        return resultContainer;
    }

    private boolean same() {
        if (curCount != targetCount) {
            return false;
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : targetMap.entrySet()) {
            Integer value = curMap.get(characterIntegerEntry.getKey());
            if (value == null || !value.equals(characterIntegerEntry.getValue())) {
                return false;
            }
        }
        return true;
    }
}