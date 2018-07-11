package string.kmp;

import java.util.Arrays;

public class Solution {

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
