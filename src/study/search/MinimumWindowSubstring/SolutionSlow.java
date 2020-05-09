package study.search.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 感觉是对的，但是超时了。
 * 太过笨重的算法了。
 */
class SolutionSlow {

    int mStart;
    int mEnd;
    boolean mHaveResult;

    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> sourceMap = buildMap(s);
        HashMap<Character, Integer> targetMap = buildMap(t);

        Iterator<Map.Entry<Character, Integer>> iterable = sourceMap.entrySet().iterator();
        while (iterable.hasNext()) {
            Character character = iterable.next().getKey();
            if (!targetMap.containsKey(character)) {
                iterable.remove();
            }
        }
        int start = 0;
        while (checkIndex(s, start) && !sourceMap.containsKey(s.charAt(start))) {
            start += 1;
        }

        int end = s.length() - 1;
        while (checkIndex(s, end) && !sourceMap.containsKey(s.charAt(end))) {
            end -= 1;
        }

        helper(s, start, end, sourceMap, targetMap);
        if (!mHaveResult) {
            return "";
        } else {
            return s.substring(mStart, mEnd + 1);
        }
    }

    private boolean checkIndex(String s, int index) {
        if (index >= 0 && index < s.length()) {
            return true;
        } else {
            return false;
        }
    }

    private void helper(
            String s,
            int start, int end,
            HashMap<Character, Integer> sourceMap, HashMap<Character, Integer> targetMap) {
        if (!checkIndex(s, start) || !checkIndex(s, end)) {
            saveResult(start, end);
            return;
        }

        if (mResultSet.contains(new Result(start, end))) {
            return;
        }

        if (start > end) {
            saveResult(start, end);
            return;
        }

        for (Character character : targetMap.keySet()) {
            if (sourceMap.get(character) == null || sourceMap.get(character) < targetMap.get(character)) {
                saveResult(start, end);
                return;
            }
        }

        if (!mHaveResult || end - start < mEnd - mStart) {
            mHaveResult = true;
            mEnd = end;
            mStart = start;
        }

        int nextStart = start + 1;
        while (checkIndex(s, nextStart) && !targetMap.containsKey(s.charAt(nextStart))) {
            nextStart += 1;
        }
        sourceMap.put(s.charAt(start), sourceMap.get(s.charAt(start)) - 1);
        helper(s, nextStart, end, sourceMap, targetMap);
        sourceMap.put(s.charAt(start), sourceMap.get(s.charAt(start)) + 1);

        int nextEnd = end - 1;
        while (checkIndex(s, nextEnd) && !targetMap.containsKey(s.charAt(nextEnd))) {
            nextEnd -= 1;
        }
        sourceMap.put(s.charAt(end), sourceMap.get(s.charAt(end)) - 1);
        helper(s, start, nextEnd, sourceMap, targetMap);
        sourceMap.put(s.charAt(end), sourceMap.get(s.charAt(end)) + 1);
        saveResult(start, end);
    }

    HashSet<Result> mResultSet = new HashSet<>();

    private void saveResult(int start, int end) {
        mResultSet.add(new Result(start, end));
    }

    private HashMap<Character, Integer> buildMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }

    class Result {
        int start;
        int end;

        public Result(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(start) + Integer.hashCode(end);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Result && ((Result) obj).start == start && ((Result) obj).end == end;
        }
    }
}