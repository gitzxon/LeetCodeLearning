package study.array.Permutation.PermutationString;

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> currentMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            Integer count = targetMap.getOrDefault(s1.charAt(i), 0);
            targetMap.put(s1.charAt(i), count + 1);
        }

        for (int i = 0; i < s2.length(); i++) {

            if (i < s1.length()) {
                Integer count = currentMap.getOrDefault(s2.charAt(i), 0);
                currentMap.put(s2.charAt(i), count + 1);
            } else {
                currentMap.put(
                        s2.charAt(i),
                        currentMap.getOrDefault(s2.charAt(i), 0) + 1
                );

                currentMap.put(
                        s2.charAt(i - s1.length()),
                        currentMap.getOrDefault(s2.charAt(i - s1.length()), 0) - 1
                );
            }

            boolean sameMap = true;
            for (Character character : targetMap.keySet()) {
                if (!targetMap.get(character).equals(currentMap.get(character))) {
                    sameMap = false;
                }
            }
            if (sameMap) {
                return true;
            }
        }

        return false;
    }
}