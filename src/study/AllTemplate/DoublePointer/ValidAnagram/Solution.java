package study.AllTemplate.DoublePointer.ValidAnagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> cur = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            target.put(s.charAt(i), target.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            cur.put(t.charAt(i), cur.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (cur.size() != target.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : target.entrySet()) {
            Character key = characterIntegerEntry.getKey();

            if (!cur.containsKey(key)) {
                return false;
            }
            if (!cur.get(key).equals(target.get(key))) {
                return false;
            }
        }

        return true;
    }
}