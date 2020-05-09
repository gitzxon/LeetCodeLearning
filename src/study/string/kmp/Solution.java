package study.string.kmp;

public class Solution {

    public int[] getNextArray(String pattern) {
        int[] lps = getLps(pattern);
        int[] next = new int[lps.length];
        next[0] = -1;
        System.arraycopy(
                lps, 0,
                next, 1,
                lps.length - 1
        );
        return next;
    }

    public int[] getLps(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return null;
        }

        if (pattern.length() == 1) {
            int[] lsp = new int[1];
            lsp[0] = 0;
            return lsp;
        }

        int[] lps = new int[pattern.length()];
        char[] str = pattern.toCharArray();
        int suffixTail = 1;
        int prefixTail = 0;
        while (suffixTail < pattern.length()) {

            if (str[suffixTail] == str[prefixTail]) {
                lps[suffixTail] = prefixTail + 1;
                suffixTail += 1;
                prefixTail += 1;
            } else {
                if (prefixTail == 0) {
                    lps[suffixTail] = 0;
                    suffixTail += 1;
                } else {
                    prefixTail = lps[prefixTail - 1];
                }
            }
        }

        return lps;
    }
}
