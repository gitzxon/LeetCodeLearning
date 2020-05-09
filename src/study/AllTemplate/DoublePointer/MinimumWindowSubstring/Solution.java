package study.AllTemplate.DoublePointer.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 一种方法是，每次比较两个map，看 currentMap contains targetMap 是否是 true；
 * 还有一种方法，是对 targetMap 计算一个 count，
 * 这个 count 就是我们还差的字母个数。
 * 每次扫描到关键 character 的时候， count--，
 * 每次缩小 start 的时候， count++。
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null && t == null) return "";
        if (s == null || t == null) return "";

        HashMap<Character, Integer> targetMap = generateCharacterToCountMap(t);

        HashMap<Character, Integer> curMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int resultStart = -1;
        int resultEnd = -1;
        while (end < s.length()) {
            Character c = s.charAt(end);
            curMap.put(c, curMap.getOrDefault(c, 0) + 1);
            while (start <= end && containsAllElement(curMap, targetMap)) {
                if (resultEnd == -1 || resultEnd - resultStart + 1 > end - start + 1) {
                    resultEnd = end;
                    resultStart = start;
                }

                curMap.put(
                        s.charAt(start),
                        curMap.getOrDefault(s.charAt(start), 1) - 1
                );
                start++;
            }
            end++;
        }
        if (resultEnd == -1 || resultStart == -1) {
            return "";
        }
        return s.substring(resultStart, resultEnd + 1);
    }

    private boolean containsAllElement(
            Map<Character, Integer> currentMap,
            Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : targetMap.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            if (targetMap.getOrDefault(key, 0) > currentMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> generateCharacterToCountMap(String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(
                    t.charAt(i),
                    targetMap.getOrDefault(t.charAt(i), 0) + 1
            );
        }
        return targetMap;
    }
}