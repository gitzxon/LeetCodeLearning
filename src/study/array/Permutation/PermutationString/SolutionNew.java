package study.array.Permutation.PermutationString;

import java.util.HashMap;

public class SolutionNew {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> currentMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            addOne(targetMap, s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            addOne(currentMap, c);

            if (i >= s1.length()) {
                minusOne(currentMap, s2.charAt(i - s1.length()));
            }

            if (i >= s1.length() - 1) {
                boolean same = true;
                for (Character character : targetMap.keySet()) {
                    if (!targetMap.get(character).equals(currentMap.get(character))) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void addOne(HashMap<Character, Integer> map, Character character) {
        map.put(character, map.getOrDefault(character, 0) + 1);
    }

    private static void minusOne(HashMap<Character, Integer> map, Character character) {
        map.put(character, map.getOrDefault(character, 0) - 1);
    }
}
