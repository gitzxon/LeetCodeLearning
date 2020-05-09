package study.string.ImplementStrstr;

class Solution {
    public int strStr(String haystack, String needle) {

        if (needle == null) return -1;
        if (needle.length() == 0) return 0;

        int[] next = getNextArray(needle);

        int tailSource = 0;
        int tailPattern = 0;
        while (tailSource < haystack.length() && tailPattern < needle.length()) {

            if (haystack.charAt(tailSource) == needle.charAt(tailPattern)) {
                tailSource += 1;
                tailPattern += 1;
            } else {
                tailPattern = next[tailPattern];
                if (tailPattern == -1) {
                    tailPattern += 1;
                    tailSource += 1;
                }
            }
        }

        if (tailPattern == needle.length()) {
            // found
            return tailSource - needle.length();
        }

        return -1;
    }

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
        if (pattern == null) return null;
        if (pattern.length() == 0) {
            int[] res = new int[1];
            res[0] = 0;
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