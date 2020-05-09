package study.array.SubstringwithConcatenationofAllWords;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable");
            }
        };

        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }

        int eachWordLength = words[0].length();
        if (s.length() < eachWordLength * words.length) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> mapWordToIndex = new HashMap<>();
        int[] wordCounts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (mapWordToIndex.containsKey(words[i])) {
                wordCounts[mapWordToIndex.get(words[i])]++;
            } else {
                mapWordToIndex.put(words[i], i);
                wordCounts[i] = 1;
            }
        }

        int[] curWordCounts = new int[wordCounts.length];

        int last = s.length() - eachWordLength + 1;
        int[] canStartHere = new int[last];
        for (int i = 0; i < canStartHere.length; i++) {
            String here = s.substring(i, i + eachWordLength);
            if (mapWordToIndex.containsKey(here)) {
                canStartHere[i] = mapWordToIndex.get(here);
            } else {
                canStartHere[i] = -1;
            }
        }

        int remains = 0;
        for (int wordCount : wordCounts) {
            if (wordCount != 0) {
                remains++;
            }
        }

        for (int i = 0; i < eachWordLength; i++) {
            int left = i;
            int right = i;
            int currentRemains = remains;
            Arrays.fill(curWordCounts, 0);

            while (right < last) {
                while (currentRemains > 0 && right < last) {
                    int targetIndexInWords = canStartHere[right];
                    if (targetIndexInWords != -1) {

                        int count = ++curWordCounts[targetIndexInWords];
                        if (count == wordCounts[targetIndexInWords]) {
                            currentRemains--;
                        }
                    }
                    right += eachWordLength;
                }

                while (currentRemains == 0 && left < right) {

                    int targetIndexInWords = canStartHere[left];
                    if (targetIndexInWords != -1) {
                        int len = (right - left);
                        if (len / eachWordLength == words.length) {
                            result.add(left);
                        }

                        curWordCounts[targetIndexInWords]--;
                        if (curWordCounts[targetIndexInWords] < wordCounts[targetIndexInWords]) {
                            currentRemains++;
                        }
                    }

                    left += eachWordLength;

                }
            }
        }
        return result;
    }

}