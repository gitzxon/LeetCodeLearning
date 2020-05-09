package study.array.AssignCookies;

import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count += 1;
                i += 1;
                j += 1;
            } else if (g[i] > s[j]) {
                j += 1;
            }
        }

        return count;
    }
}

