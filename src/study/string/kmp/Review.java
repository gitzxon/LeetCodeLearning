package study.string.kmp;


// 2018/07/18 复习 kmp
public class Review {

    public int[] getNextArray(String pattern) {
        int[] lps = getLps(pattern);
        int[] next = new int[lps.length];
        System.arraycopy(
                lps, 0, next, 1, lps.length - 1);
        next[0] = -1;
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

        int length = pattern.length();
        int[] lsp = new int[length];

        int prefixTail = 0;
        int suffixTail = 1;
        while (suffixTail < length) {
            if (pattern.charAt(prefixTail) == pattern.charAt(suffixTail)) {
                lsp[suffixTail] = prefixTail + 1;
                prefixTail += 1;
                suffixTail += 1;
            } else {
                if (prefixTail == 0) {
                    lsp[suffixTail] = 0;
                    suffixTail += 1;
                } else {
                    prefixTail = lsp[prefixTail - 1];
                }
            }
        }

        return lsp;
    }

}
