package study.misc.WildcardMatching;

class Solution {
    boolean isMatch(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();
        int i = 0;
        int j = 0;
        int asterisk = -1;
        int match = -1;
        while (i < m) {
            if (j < n && pattern.charAt(j) == '*') {
                match = i;
                asterisk = j;
                j++;
            } else if (j < n && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                i++;
                j++;
            } else if (asterisk >= 0) {
                i = match + 1;
                j = asterisk + 1;
                match++;
            } else {
                return false;
            }
        }

        while (j < n && pattern.charAt(j) == '*') j++;

        return j == n;
    }
}