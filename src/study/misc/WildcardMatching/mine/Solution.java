package study.misc.WildcardMatching.mine;

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int asteriskForI = -1;
        int asteriskForJ = -1;

        int n = s.length();
        int m = p.length();
        while (i < n) {
            if (j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) == '*') {
                asteriskForI = i;
                asteriskForJ = j;
                j++;
            } else if (asteriskForI >= 0) {
                i = asteriskForI + 1;
                asteriskForI++;
                j = asteriskForJ;
            } else {
                return false;
            }
        }

        while (j < m && p.charAt(j) == '*') j++;

        return j == m;

    }
}