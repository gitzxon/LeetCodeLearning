package study.string.WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> used = new HashSet<>();

        int sizeForLevel = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (calDistanceString(beginWord, wordList.get(i)) == 1) {
                queue.add(i);
                used.add(i);
                sizeForLevel += 1;
            }
        }
        int level = 1;

        while (queue.size() != 0) {

            int sizeForNextLevel = 0;
            for (int i = 0; i < sizeForLevel; i++) {
                int index = queue.poll();
                String word = wordList.get(index);
                if (word.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (!used.contains(j) && calDistanceString(word, wordList.get(j)) == 1) {
                        queue.add(j);
                        sizeForNextLevel += 1;
                        used.add(j);
                    }
                }
            }
            level += 1;
            sizeForLevel = sizeForNextLevel;
        }

        return 0;

    }


    private int calDistanceString(String a, String b) {
        if (a.length() != b.length()) {
            throw new IllegalArgumentException("len must be same");
        }

        int distance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance += 1;
            }
        }
        return distance;
    }
}