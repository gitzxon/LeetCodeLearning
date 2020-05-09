package study.search.MinimumWindowSubstring;

class Solution {
    public String minWindow(String s, String t) {

        if (s == null || t == null) return "";

        // total number of character in p to be contained in s
        int countToBeContained = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        // calculate the number of each character to be contained in S
        int[] remainingDict = new int[128];
        for (char c : t.toCharArray()) {
            remainingDict[c]++;
        }

        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            // if need to be contained, include it and minus the counter
            if (remainingDict[s.charAt(fast)] > 0) {
                countToBeContained--;
            }
            remainingDict[s.charAt(fast)]--;
            fast++;

            // all included, move the slow pointer to minimize the window
            while (countToBeContained == 0) {
                // current window contains same number of the current character as in t, cannot move forward anymore
                if (remainingDict[s.charAt(slow)] == 0) {
                    countToBeContained++;
                }
                remainingDict[s.charAt(slow)]++;
                slow++;

                // update minLen
                if (fast - slow + 1 < minLen) {
                    startIndex = slow - 1;
                    minLen = fast - slow + 1;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}