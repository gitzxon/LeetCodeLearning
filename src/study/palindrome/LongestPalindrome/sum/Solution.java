package study.palindrome.LongestPalindrome.sum;

class Solution {
    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] map = new int[128];

        int count = 0;
        boolean hasOdd = false;

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        for (int i = 0; i < map.length; i++) {

            if (map[i] == 0) {
                continue;
            }

            int value = map[i];
            if (value % 2 == 0) {
                count += value;
            } else {
                count += value - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            count += 1;
        }
        return count;
    }
}